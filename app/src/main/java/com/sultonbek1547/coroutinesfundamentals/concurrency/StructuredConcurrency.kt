package com.sultonbek1547.coroutinesfundamentals.concurrency

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

/**
 *  Structured concurrency helps us to keep track of tasks
 *  we started and cancel them when needed
 *
 * */
class StructuredConcurrency {
    var count = 0
    lateinit var deffered: Deferred<Int>
    suspend fun getTotalUserCount(): Int {
        coroutineScope {
            launch(IO) {
                delay(2000) // do some heavy tasks
                count = 50
            }

            deffered = async(Dispatchers.IO) {
                delay(4000) // do some heavy tasks here too
                return@async 70
            }

        }


        return count + deffered.await()
    }

}