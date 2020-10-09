package com.github.hammer.commons.rcode

import com.google.inject.Singleton
import java.io.FileNotFoundException
import java.lang.IllegalStateException
import java.util.*
import kotlin.collections.HashMap

/**
 *
 * @author he peng
 * @date 2020-08-07
 */



@Singleton
class PropertiesRCodeLoader(
        var filePath:String = DEFAULT_FILE_PATH
        , var codeMsgSeparator:String = DEFAULT_CODE_MSG_SEPARATOR) : AbstractRCodeLoader() {

    companion object {
        const val DEFAULT_FILE_PATH = "META-INF/R-CODE/"
        const val DEFAULT_CODE_MSG_SEPARATOR = ","
    }

    override fun doLoad(className: String): MutableMap<String, Pair<String, String>> {

        val default = loadDefault(className)
        val userDefined = loadUserDefined(className)
        return default.apply { this.putAll(userDefined) }
    }

    private fun loadDefault(className: String): MutableMap<String, Pair<String, String>> {
        return load0(filePath.plus(className).plus(".default.properties"))
    }

    private fun loadUserDefined(className: String): MutableMap<String, Pair<String, String>> {
        return load0(filePath.plus(className).plus(".properties"))
    }

    private fun load0(file: String): MutableMap<String, Pair<String, String>> {
        val properties = Properties()
        for (resource in Thread.currentThread().contextClassLoader.getResources(file)) {
            val stream = resource.openStream()

            if (Objects.isNull(stream)) {
                throw FileNotFoundException("file [$file] Not Found")
            }
            properties.load(resource.openStream())
        }

        val enumRCode: MutableMap<String, Pair<String, String>> = HashMap()
        for (entry in properties.entries) {
            if ((entry.value as String).isNullOrEmpty()) {
                throw IllegalStateException("The value of ${entry.key} key in $file file is empty")
            }
            val vals = (entry.value as String).split(codeMsgSeparator.trim())
            if (vals.size < 2) {
                throw IllegalStateException("The value of ${entry.key} key in $file file is incomplete")
            }
            enumRCode[entry.key as String] = Pair(vals[0].trim(), vals[1].trim())
        }

        return enumRCode
    }
}
