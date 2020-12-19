package com.swiper.store.ui.wallet

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.model.repository.ApiRepository
import com.swiper.store.ui.base.BaseViewModel
import com.swiper.store.model.vo.MeItem

class WalletViewModel @ViewModelInject constructor(
    private var apiRepository: ApiRepository
) : BaseViewModel() {

    private val _meResult = MutableLiveData<MeItem>()
    val meResult: LiveData<MeItem> = _meResult

    fun getMe() {
        _meResult.value = apiRepository.fetchMe()
    }
}