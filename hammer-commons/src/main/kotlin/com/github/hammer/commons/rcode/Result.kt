package com.github.hammer.commons.rcode

/**
 *
 * @author he peng
 * @date 2020-08-07
 */
interface Result<D: Any , R: RCode> {

    fun data(): D?

    fun code(): R

    fun isOk(): Boolean
}