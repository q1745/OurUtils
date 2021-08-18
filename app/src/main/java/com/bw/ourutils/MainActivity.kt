package com.bw.ourutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bw.ourutils.databinding.ActivityMainBinding
import com.shuke.mvpcore.annotation.MvpPresenter
import com.shuke.mvpcore.view.MvpActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.user = User("志强","吃屎")

    }

}