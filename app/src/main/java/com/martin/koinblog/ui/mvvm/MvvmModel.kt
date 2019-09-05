package com.martin.koinblog.ui.mvvm

/**
 * @author：孟凡华
 * @date：2019/9/5 9:19
 */
class MvvmModel {

    /**
     * 模拟获取消息
     */
    fun getMsg(): String {
        return "这是一个普通的消息"
    }

    fun getError(): String {
        return "这是一个错误提醒"
    }
}