package com.martin.koinblog.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author：孟凡华
 * @date：2019/9/4 15:25
 */
class VmViewModel : ViewModel() {

    val count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun addCount() {
        count.value = count.value!!.toInt() + 1
    }

}