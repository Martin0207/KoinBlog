package com.martin.koinblog.ui.mvvm

import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.context.GlobalContext
import org.koin.core.inject

/**
 * @author：孟凡华
 * @date：2019/9/5 9:19
 */
class MvvmViewModel(private val mView: IMvvmView) : ViewModel(),
    /**
     * 标示该类为Koin的组件，这样就可以在该类自由的使用 get()/inject()
     * 当然，如果你是个狼人，就喜欢不按套路走，也可以不实现该接口，使用
     * GlobalContext.get().koin.get()
     * GlobalContext.get().koin.inject()
     */
    KoinComponent {

    private val mModel: MvvmModel by inject()

    fun show() {

        mView.showMsg(mModel.getMsg())
    }

    fun error() {
        mView.showError(mModel.getError())
    }

}