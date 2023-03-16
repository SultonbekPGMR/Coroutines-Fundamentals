package com.sultonbek1547.coroutinesfundamentals.concurrency

import kotlinx.coroutines.*

/**
 * In unstructured concurrency whether we use launch or async builders,
 * there is NO way to properly handle exceptions.
 * */
class UnstructuredConcurrency {
    suspend fun getTotalUserCount(): Int {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        val deffered = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }

        return count + deffered.await()
    }

}