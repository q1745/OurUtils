package com.shuke.mvpcore

import com.shuke.common.InjectUtil

/**
 *   @Author:YaPeng
 *   @Date:2021/8/11
 *   @Email:3536815334@qq.com
 *
 *   仓库层
 *   实现网络判断
 *   从不同Model获取数据展示
 *   依赖注解+反射实现一个Repository 对应多个Model
 */
class BaseRepostory {

    init {
        initModel()
    }

    private fun initModel() {
        InjectUtil.InjectModel(this)
    }
}