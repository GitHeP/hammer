package com.github.hammer.commons.rcode

import com.google.inject.AbstractModule

/**
 *
 * @author he peng
 * @date 2020-08-07
 */
class RCodeNamespaceModule : AbstractModule() {

    override fun configure() {
        bind(RCodeNamespace::class.java).to(EmptyRCodeNamespace::class.java)
    }
}