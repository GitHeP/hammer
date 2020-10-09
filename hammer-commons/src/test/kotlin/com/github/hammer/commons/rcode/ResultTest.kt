package com.github.hammer.commons.rcode

import org.junit.Assert.*
import org.junit.Test

/**
 * @author he peng
 * @date 2020-08-07
 */
class SyncResultTest {

    @Test
    fun test() {

        val syncResult = callServiceA<String , RCode>()
        println(syncResult)
    }

    private fun <D: Any , R: RCode> callServiceA(): SyncResult<String, RCode> = SyncResult("AXC", GeneralRCode.SUCCEEDED)
}