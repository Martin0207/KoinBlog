package com.martin.koinblog.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.koinblog.R
import com.martin.koinblog.base.BaseAdapter
import com.martin.koinblog.loge
import com.martin.koinblog.showSnack
import com.martin.koinblog.ui.factory.FactoryActivity
import com.martin.koinblog.ui.mvvm.MvvmActivity
import com.martin.koinblog.ui.single.SingleActivity
import com.martin.koinblog.ui.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_text_normal.view.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainViewModel by viewModel()

    private val mAdapter by lazy {
        BaseAdapter<String>(
            this,
            R.layout.item_text_normal,
            mViewModel.getItems()
        ) { itemView, item, position ->
            itemView.tv.text = item
            itemView.setOnClickListener {
                when (item) {
                    "factory" -> {
                        FactoryActivity.start(this)
                    }
                    "single" -> {
                        SingleActivity.start(this)
                    }
                    "viewModel" -> {
                        ViewModelActivity.start(this)
                    }
                    "mvvm" -> {
                        MvvmActivity.start(this)
                    }
                    else -> {
                        showSnack(item, itemView)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lv.adapter = mAdapter
    }
}
