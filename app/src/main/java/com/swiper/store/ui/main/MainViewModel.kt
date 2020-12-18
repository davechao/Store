package com.swiper.store.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _badgeResult = MutableLiveData<Int>()
    val badgeResult: LiveData<Int> = _badgeResult

    fun fetchBadge() {
        _badgeResult.value = 1
    }
}