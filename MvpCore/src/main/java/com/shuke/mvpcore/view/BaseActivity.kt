package com.shuke.mvpcore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuke.common.StatusBarUtil

/**
 *   @Author:YaPeng
 *   @Date:2021/8/11
 *   @Email:3536815334@qq.com
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if(IsClearState()){
            StatusBarUtil.clearStatusBar(this)
        }
        initView()
        initData()
        initEvent()
    }

    /**
     * 是否设置沉浸式状态布局
     */
    fun IsClearState(): Boolean{
        return true
    }

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化
     */
    abstract fun initView()

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int
}