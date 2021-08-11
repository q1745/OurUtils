package com.shuke.mvpcore

import com.shuke.common.InjectUtil

/**
 *   @Author:YaPenggit
 *   @Date:2021/8/11
 *   @Email:3536815334@qq.com
 */
abstract class BasePresenter<V : IView,R : BaseRepostory>(_view : V) {
    protected lateinit var mView : V
    protected lateinit var mRepository : R
    init {
        mView = _view
        mRepository = createRepository()
    }

    abstract fun createRepository(): R


}