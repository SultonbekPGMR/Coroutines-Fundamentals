package com.sultonbek1547.coroutinesfundamentals

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("SALOM", "MAIN: ${Thread.currentThread().name}")
        }
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("SALOM", "BACKGROUND: ${Thread.currentThread().name}")
        }


        // runncing functions parallel (at the same time) with async. And none parallel
        CoroutineScope(IO).launch {
            /** running two functions parallel */
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }
            val total = stock1.await() + stock2.await()
            Log.i(TAG, "onCreate: Total is $total")

            /** running two functions ketma-ket*/
//            val stock1 = getStock1()
//            val stock2 = getStock2()
//            val total = stock1 + stock2
//            Log.i(TAG, "onCreate: Total is $total")

        }



    }

    // Switching between threads
    private suspend fun downloadUser() {
        for (i in 0 until 200000) {
            withContext(Dispatchers.Main) {// switching from background thread to Main thread
                // now you can make change to UI

            }
        }

    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.i(TAG, "getStock1: stock 1 is returned")
        return 55000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.i(TAG, "getStock1: stock 2 is returned")
        return 35000
    }

}



