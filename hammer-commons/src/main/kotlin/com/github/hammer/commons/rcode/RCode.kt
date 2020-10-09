package com.github.hammer.commons.rcode

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.Serializable


/**
 * Response Code 响应码。
 * RCode 的目的是为了提供方法调用或者是分布式环境下服务调用的结果说明。
 * 在代码中尤其是分布式环境中应该不要去使用 Exception 来进行流程控制。
 *
 * @author he peng
 * @date 2020-08-06
 *
 */
interface RCode : Serializable {

    fun namespace(): String = BACKER.rCodeNamespace.namespace()

    fun code(): String = rCode().first

    fun msg(): String = rCode().second

    /**
     * 判断调用是否成功， return true 表示成功， return false 表示失败
     */
    fun isSuccessful() = GeneralRCode.SUCCEEDED.code() == this.code()

    fun rCodeToString(): String = "${this.javaClass.simpleName} : ${extractEnumName()} = [namespace = ${namespace()} , code = ${code()} , msg = ${msg()}]"

    private fun rCode(): Pair<String , String> {
        if (! this.javaClass.isEnum) {
            throw IllegalStateException("${this.javaClass.name} this instance is not an enum type");
        }

        return BACKER.rCodeLoader.load(this.javaClass.name , extractEnumName())
    }

    private fun extractEnumName(): String = this.javaClass.superclass.getDeclaredField("name")
            .apply { this.isAccessible = true }.get(this).toString()

    companion object {

        @JvmStatic
        val BACKER = Guice.createInjector(RCodeLoaderModule() , RCodeNamespaceModule()).getInstance(RCodeBacker::class.java)!!
    }

    @Singleton
    class RCodeBacker : RCode {
        @Inject
        lateinit var rCodeLoader: RCodeLoader

        @Inject
        lateinit var rCodeNamespace: RCodeNamespace
    }

}

enum class GeneralRCode : RCode {

    SUCCEEDED ,

    UNKNOWN_ERROR;

}