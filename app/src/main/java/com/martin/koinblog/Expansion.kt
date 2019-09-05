package com.martin.koinblog

import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * @author：孟凡华
 * @date：2019/9/4 13:29
 */

fun loge(msg: String, tag: String = "normal") {
    Log.e(tag, msg)
}

fun showSnack(msg: String, view: View) {
    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
}