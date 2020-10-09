package com.github.hammer.commons.rcode

/**
 *
 * @author he peng
 * @date 2020-08-07
 */
class ResultImpl<D: Any ,  R: RCode>() : Result<D, R> {

    lateinit var code: R
    var data: D? = null

    constructor(data: D? , code: R) : this() {
        this.code = code
        this.data = data
    }

    override fun data(): D? = data

    override fun code(): R = code

    override fun isOk(): Boolean = code.isSuccessful()

    override fun toString(): String = "Result of the call [isOk = ${isOk()} , data = $data , code = ${code.rCodeToString()}]"
}