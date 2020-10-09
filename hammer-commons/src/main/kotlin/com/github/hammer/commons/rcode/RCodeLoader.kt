package com.github.hammer.commons.rcode


/**
 * RCode 加载器
 *
 * @author he peng
 * @date 2020-08-06
 */
interface RCodeLoader {

    fun load(className: String , enumName: String): Pair<String , String>
}

