package com.swiper.store.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.swiper.store.R
import com.swiper.store.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}