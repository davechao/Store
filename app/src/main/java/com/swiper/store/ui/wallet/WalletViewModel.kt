package com.swiper.store.ui.wallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.ui.base.BaseViewModel
import com.swiper.store.ui.model.vo.MeItem

class WalletViewModel : BaseViewModel() {

    private val _meResult = MutableLiveData<MeItem>()
    val meResult: LiveData<MeItem> = _meResult

    fun getMe() {
        _meResult.value = MeItem(
            "Starbucks",
            "store",
            "https://www.shareicon.net/data/128x128/2015/09/01/94011_starbucks_512x512.png"
        )
    }

}