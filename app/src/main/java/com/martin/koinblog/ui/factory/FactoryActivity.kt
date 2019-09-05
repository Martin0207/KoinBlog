package com.martin.koinblog.ui.factory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.koinblog.R
import com.martin.koinblog.loge
import kotlinx.android.synthetic.main.activity_factory.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class FactoryActivity : AppCompatActivity() {

    /**
     * 使用[inject]获取FactoryModel实例
     * 其他教程中有说也可以使用[get]获取
     * 并且[inject]知识[lazy]版的[get]
     * 可以点开[inject]看到源码确实如此，但我这里是用[get]时提示
     * `Missing 'getValue(FactoryActivity, KProperty<*>)' method on delegate of type 'FactoryModel'`
     * 推荐:
     * 获取实例时使用[inject],初始化Koin时使用[get]
     */
    private val mModelOne: FactoryModel by inject()
    private val mModelTwo: FactoryModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factory)

        btn_show.setOnClickListener {
            val msg = "one model is:\n $mModelOne\ntwo model is:\n $mModelTwo"
            loge(msg)
            tv.text = msg
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, FactoryActivity::class.java))
        }
    }
}
