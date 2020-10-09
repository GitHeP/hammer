package com.github.hammer.commons.rcode

import com.google.inject.Singleton

/**
 *
 * @author he peng
 * @date 2020-08-07
 */
@Singleton
class EmptyRCodeNamespace : RCodeNamespace {

    override fun namespace(): String = ""
}