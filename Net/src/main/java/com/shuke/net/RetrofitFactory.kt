package com.shuke.net

/**
 *   @Author:YaPeng
 *   @Date:2021/8/18
 *   @Email:3536815334@qq.com
 */
class RetrofitFactory {

    companion object{
        @Volatile
        private lateinit var instance : RetrofitFactory

        @Synchronized
        fun getinstance():RetrofitFactory{
            if (instance == null){
                instance = RetrofitFactory()
            }
            return instance
        }

    }

}