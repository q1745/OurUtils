package com.shuke.common

import android.os.Build
import com.shuke.mvpcore.BaseRepostory
import com.shuke.mvpcore.annotation.MvpModel
import com.shuke.mvpcore.annotation.MvpPresenter
import java.lang.IllegalStateException

/**
 *   @Author:YaPeng
 *   @Date:2021/8/11
 *   @Email:3536815334@qq.com
 */
object InjectUtil {
    /**
     * 依赖注入+反射初始化P层
     */
    fun InjectPresenter(obj : Any){
        //获取当前类型
        val thatType = obj.javaClass
        val declaredFields = thatType.declaredFields
        if (declaredFields.size > 0){
            var hasPresenter : Boolean = false
            for (field in declaredFields){
                val annotation = field.getAnnotation(MvpPresenter::class.java)
                if (annotation == null){
                    continue
                }
                var name = ""
                if (Build.VERSION.SDK_INT >= 28){
                    name = field.genericType.typeName
                }else{
                    name = field.type.name
                }
                val forName = Class.forName(name)
                var constructors = forName.constructors
                val newInstance = constructors.get(0).newInstance()
                field.set(obj,newInstance)
            }
        }
    }
    /**
     * 依赖注入+反射初始化M层
     */
    fun InjectModel(obj: Any) {
        //获取到当前参数类型
        val thatType = obj.javaClass
        //获取到当前类型所有字段并进行判断
        val declaredFields = thatType.declaredFields
        if (declaredFields.size > 0){
            //用于判断当前类型是否存在Model字段
            var hasModel : Boolean = false
            //循环遍历进行初始化
            for (field in declaredFields){
                //拿到字段是否有MvpModel注解修饰
                val annotation = field.getAnnotation(MvpModel::class.java)
                if (annotation == null){
                    continue
                }
                //打开可访问性
                field.isAccessible = true
                //字段类型name
                var name : String = ""
                if (Build.VERSION.SDK_INT >= 28){
                    name = field.genericType.typeName
                }else{
                    name = field.type.name
                }
                //取到当前字段类型
                val fieldType = Class.forName(name)
                //通过反射的NewInstance来获取实例
                val newInstance = fieldType.newInstance()
                field.set(obj,newInstance)
                hasModel = true
            }
            if (!hasModel){
                throw IllegalStateException("has no Model")
            }
        }else{
            throw IllegalStateException("has no field")
        }

    }


}