package com.github.hammer.commons.rcode

import com.google.inject.Singleton

/**
 * 为 RCode 提供一个可以判断 RCode 来源的命名空间 。
 * 例如 : aservice:10000 , bservice:10000 .
 * RCode 都是 10000 , 可以通过 namespace aservice 和 bservice 来进行区分。
 *
 * @author he peng
 * @date 2020-08-06
 */
interface RCodeNamespace {

    fun namespace(): String
}



