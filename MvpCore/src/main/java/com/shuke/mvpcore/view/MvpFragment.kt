package com.shuke.mvpcore.view

import com.shuke.common.InjectUtil

/**
 *   @Author:YaPeng
 *   @Date:2021/8/11
 *   @Email:3536815334@qq.com
 */
abstract class MvpFragment : BaseFragment(){

    init {
        initPresenter()
    }

    fun initPresenter(){
        InjectUtil.InjectPresenter(this)
    }
}