package com.shuke.mvvmcore

import android.os.Build
import com.shuke.mvvmcore.annotation.MVVMModel

/**
 *   @Author:YaPeng
 *   @Date:2021/8/18
 *   @Email:3536815334@qq.com
 *   反射加注解方式实现一个Repository对应多个Model
 */
abstract class BaseRepository {

    init{
        injectModel()
    }

    fun injectModel(){
        val javaClass = this.javaClass
        val declaredFields = javaClass.declaredFields
        if (declaredFields.size > 0){
            var hasModel: Boolean = false
            for(field in declaredFields){
                val annotation = field.getAnnotation(MVVMModel::class.java)
                if (annotation == null){
                    continue
                }
                hasModel = true
                field.isAccessible = true
                var name : String = ""
                if (Build.VERSION.SDK_INT >= 28){
                    name = field.genericType.typeName
                }else{
                    name = field.name
                }
                val forName = Class.forName(name)
                val newInstance = forName.newInstance()
                field.set(this,newInstance)
            }
            if (!hasModel){
                throw IllegalStateException("MVVM Repository 没有Model")
            }
        }
        else{
            throw IllegalStateException("MVVM Repository 没有字段")
        }
    }
}