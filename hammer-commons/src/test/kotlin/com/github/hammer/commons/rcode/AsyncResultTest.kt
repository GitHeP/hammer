package com.github.hammer.commons.rcode

import org.junit.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * @author he peng
 * @date 2020-08-07
 */
class AsyncResultTest {

    @Test fun test() {

        val threadPool = Executors.newFixedThreadPool(3)

        val future = threadPool.submit(MyCallableImpl())

//        println(AsyncResult(future))
    }

}

class MyCallableImpl : Callable<SyncResult<Any, RCode>> {

    override fun call(): SyncResult<Any, RCode> {
        println("thread started ... ")
        TimeUnit.SECONDS.sleep(5)
        println("thread end ... ")
        return SyncResult("ASCVF" , GeneralRCode.UNKNOWN_ERROR)
    }
}