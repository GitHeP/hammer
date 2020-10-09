package com.github.hammer.commons.rcode

import com.google.inject.AbstractModule

/**
 *
 * @author he peng
 * @date 2020-08-07
 */
class RCodeLoaderModule : AbstractModule() {

    override fun configure() {
        bind(RCodeLoader::class.java).to(PropertiesRCodeLoader::class.java)
        bind(RCode::class.java).to(RCode.RCodeBacker::class.java)
    }
}