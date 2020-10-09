package com.github.hammer.commons.rcode

import com.github.hammer.commons.rcode.RCode.*
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

/**
 * @author he peng
 * @date 2020-08-06
 */
class GeneralRCodeTest {

    @Test
    fun succeededTest() {
        Assert.assertEquals(GeneralRCode.SUCCEEDED.code() , "0")
        Assert.assertEquals(GeneralRCode.SUCCEEDED.msg() , "SUCCEEDED")
        println("code = ${GeneralRCode.SUCCEEDED.code()} , msg = ${GeneralRCode.SUCCEEDED.msg()}")
        println(GeneralRCode.UNKNOWN_ERROR.rCodeToString())
    }
}