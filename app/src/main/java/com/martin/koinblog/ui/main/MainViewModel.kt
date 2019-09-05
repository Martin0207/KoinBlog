package com.martin.koinblog.ui.main

import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * @author：孟凡华
 * @date：2019/9/4 9:46
 */
class MainViewModel(private val mModel: MainModel) : ViewModel(),
    KoinComponent {

    fun getItems() = mModel.items()

}