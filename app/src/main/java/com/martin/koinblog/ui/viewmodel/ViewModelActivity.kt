package com.martin.koinblog.ui.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.martin.koinblog.R
import kotlinx.android.synthetic.main.activity_view_model.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewModelActivity : AppCompatActivity() {

    /**
     * 这里区分开来:
     * mViewModel由Koin的[viewModel]来生成
     * mViewModel2由[ViewModelProvider]生成
     * mModel由本身构造函数生成
     * 旋转屏幕后看是否具有原生ViewModel的功能
     */
    private val mViewModel: VmViewModel by viewModel()
    private val mViewModel2: VmViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(VmViewModel::class.java)
    }
    private val mModel: VmViewModel by lazy { VmViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        mViewModel.count.observe(this, Observer {
            tv_vm.text = it.toString()
        })
        mViewModel2.count.observe(this, Observer {
            tv_vm2.text = it.toString()
        })
        mModel.count.observe(this, Observer {
            tv_m.text = it.toString()
        })

        btn_vm.setOnClickListener {
            mViewModel.addCount()
        }
        btn_vm2.setOnClickListener {
            mViewModel2.addCount()
        }
        btn_m.setOnClickListener {
            mModel.addCount()
        }

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ViewModelActivity::class.java))
        }
    }
}
