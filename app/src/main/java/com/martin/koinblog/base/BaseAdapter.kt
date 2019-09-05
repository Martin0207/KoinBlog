package com.martin.koinblog.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * @author：孟凡华
 * @date：2019/9/4 14:15
 */
class BaseAdapter<T>(
    val context: Context,
    val itemId: Int,
    val data: ArrayList<T>,
    val initItem: (itemView: View, item: T, position: Int) -> Unit
) : BaseAdapter() {

    private val mInflate by lazy {
        LayoutInflater.from(context)
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView = p1 ?: mInflate.inflate(itemId, p2, false)
        initItem(itemView, getItem(p0), p0)
        return itemView
    }

    override fun getItem(p0: Int): T {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}