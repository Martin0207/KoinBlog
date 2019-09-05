package com.martin.koinblog.ui.single

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.koinblog.R
import com.martin.koinblog.loge
import com.martin.koinblog.ui.factory.FactoryActivity
import com.martin.koinblog.ui.factory.FactoryModel
import kotlinx.android.synthetic.main.activity_factory.*
import org.koin.android.ext.android.inject

class SingleActivity : AppCompatActivity() {

    private val mModelOne: SingleModel by inject()
    private val mModelTwo: SingleModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        btn_show.setOnClickListener {
            val msg = "one model is:\n $mModelOne\ntwo model is:\n $mModelTwo"
            loge(msg)
            tv.text = msg
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SingleActivity::class.java))
        }
    }
}
