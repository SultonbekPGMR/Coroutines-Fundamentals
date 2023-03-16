package com.sultonbek1547.coroutinesfundamentals.withviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/** 16.03.2023
 *  viewModelScope is a CoroutineScope tied to a ViewModel
 * */
class MainActivityViewModel : ViewModel() {

    fun getUserData() {
        viewModelScope.launch {
            // write some code
            /**
             * Now you do not need to override onCleared.
             * Clearing will be done automatically
             * */

        }

    }
}