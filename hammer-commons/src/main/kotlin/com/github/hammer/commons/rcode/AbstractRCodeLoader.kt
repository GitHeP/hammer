package com.github.hammer.commons.rcode

import java.util.concurrent.ConcurrentHashMap

/**
 *
 * @author he peng
 * @date 2020-08-06
 */
abstract class AbstractRCodeLoader : RCodeLoader {

    private val rCodeCache: MutableMap<String , MutableMap<String , Pair<String , String>>> = ConcurrentHashMap(200)

    override fun load(className: String , enumName: String): Pair<String , String> {
        if (! rCodeCache.containsKey(className)) {
            val enumRCode = doLoad(className)
            if (enumRCode.isNotEmpty()) {
                rCodeCache[className] = enumRCode
            }
        }

        return rCodeCache[className]?.get(enumName)!!
    }

    abstract fun doLoad(className: String): MutableMap<String , Pair<String , String>>
}