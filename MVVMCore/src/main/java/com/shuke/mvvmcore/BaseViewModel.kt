package com.shuke.mvvmcore

import androidx.lifecycle.*

/**
 *   @Author:YaPeng
 *   @Date:2021/8/18
 *   @Email:3536815334@qq.com
 */
abstract class BaseViewModel<Repo : BaseRepository>() : ViewModel() , LifecycleEventObserver{
    protected lateinit var repo : Repo
    private lateinit var owner: LifecycleOwner
    init {
        repo = createRepository()
    }
    abstract fun createRepository(): Repo

    constructor(lifecycle : LifecycleOwner) : this() {
        owner = lifecycle
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun uiConnection(){
        initResource()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disConnection(){
        releaseResource()
        owner.lifecycle.removeObserver(this)
    }

    abstract fun releaseResource()

    abstract fun initResource()

}