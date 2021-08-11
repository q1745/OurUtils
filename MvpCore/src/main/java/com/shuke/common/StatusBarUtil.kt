package com.shuke.common

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

/**
 *   @Author:YaPeng
 *   @Date:2021/8/11
 *   @Email:3536815334@qq.com
 */
object StatusBarUtil {
    /**
     * WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS -> 透明状态栏
     * WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION -> 透明导航栏
     * View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN -> 全屏布局
     * View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION -> 隐藏导航栏
     * View.SYSTEM_UI_FLAG_LAYOUT_STABLE -> 稳定布局
     *
     * Color.TRANSPARENT -> 透明
     *
     */

    fun clearStatusBar(context : AppCompatActivity){
        //取消状态栏标题
        context.window.requestFeature(Window.FEATURE_NO_TITLE)
        //判断版本是否大于等于21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window : Window = context.window
            //定义页面可以拉伸到顶部状态栏，并且定义顶部状态栏透明
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置状态栏为透明
            window.statusBarColor = Color.TRANSPARENT
            //设置虚拟按键为透明
            window.navigationBarColor = Color.TRANSPARENT
        }
        val actionBar:ActionBar? = context.supportActionBar
        //隐藏actionBar
        actionBar?.hide()
    }
}