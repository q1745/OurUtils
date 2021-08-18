package com.shuke.mvvmcore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.shuke.mvvmcore.BaseViewModel

/**
 *   @Author:YaPeng
 *   @Date:2021/8/18
 *   @Email:3536815334@qq.com
 */
abstract class MVVMActivity<V : ViewDataBinding,VM : BaseViewModel<*>> : AppCompatActivity(){

    protected lateinit var binding:V
    protected lateinit var viewModel : VM
    private var vars : MutableMap<Int,Any> = mutableMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayoutId())

        prepareVars(vars)
        setVars(binding,vars)

        loadData()
        initEvent()
    }

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 加载数据
     */
    abstract fun loadData()

    /**
     * 设置变量
     */
    fun setVars(binding: V, vars: MutableMap<Int, Any>){
        vars.forEach{
            binding.setVariable(it.key,it.value)
        }
    }

    /**
     * 往Map中添加vars
     */
    abstract fun prepareVars(vars: MutableMap<Int, Any>)

    /**
     * 获取布局Id
     */
    abstract fun getLayoutId(): Int
}