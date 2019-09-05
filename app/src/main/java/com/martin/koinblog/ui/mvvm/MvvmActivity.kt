package com.martin.koinblog.ui.mvvm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.martin.koinblog.R
import com.martin.koinblog.databinding.ActivityMvvmBinding
import com.martin.koinblog.showSnack
import kotlinx.android.synthetic.main.activity_mvvm.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MvvmActivity : AppCompatActivity(), IMvvmView {

    /**
     * 用Koin获取ViewModel
     * 因为[MvvmViewModel]的构造函数有IMvvmView,且Koin无法提供其实现
     * 这里需要手动添加该参数,配合App中的[viewModel { (view: IMvvmView) -> MvvmViewModel(view) }]
     */
    private val mViewModel: MvvmViewModel by viewModel {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMvvmBinding>(this, R.layout.activity_mvvm)

        binding.viewModel = mViewModel

    }

    override fun showMsg(msg: String) {
        showSnack(msg, btn_show)
    }

    override fun showError(error: String) {
        showSnack(error, btn_error)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MvvmActivity::class.java))
        }
    }
}
