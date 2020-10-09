package com.github.hammer.commons.rcode

import org.junit.Test

/**
 *
 * @author he peng
 * @date 2020-08-07
 */
class FunInvokeChainTest {

    @Test fun test() {
        AClass().funA()

    }
}

class AClass {

    fun funA(): RCode {
        val r = BClass().funB()
//        for (element in RuntimeException().stackTrace) {
//            println(element)
//        }
        return r
    }
}

class BClass {

    fun funB(): RCode = GeneralRCode.SUCCEEDED
}