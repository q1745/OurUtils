package com.shuke.mvpcore.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    /**
     * 页面跳转 无参
     */
    fun jumpActivity(target: Class<*>){
        startActivity(Intent(this@BaseActivity,target))
    }

    /**
     * 页面跳转 有参
     */
    fun jumpActivity(target: Class<*>,params:Bundle?){
        var intent : Intent = Intent(this@BaseActivity,target)
        intent.putExtra("params",params)
        startActivity(intent)
    }

    /**
     * 显示短时间消息 吐司
     */
    fun showShortMsg(msg:String){
        Toast.makeText(this@BaseActivity, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 显示长时间消息 吐司
     */
    fun showLongMsg(msg:String){
        Toast.makeText(this@BaseActivity, msg, Toast.LENGTH_LONG).show()
    }

    /**
     * 查找资源
     */
    fun <T : View> Find(id : Int) : T{
        return findViewById(id)
    }

    /**
     * 释放资源
     */
    abstract fun releaseResource()

    /**
     * 页面销毁释放资源
     */
    override fun onDestroy() {
        super.onDestroy()
        releaseResource()
    }
}