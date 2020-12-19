package com.swiper.store.ui.wallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.ui.base.BaseViewModel
import com.swiper.store.model.vo.MeItem

class WalletViewModel : BaseViewModel() {

    private val _meResult = MutableLiveData<MeItem>()
    val meResult: LiveData<MeItem> = _meResult

    fun getMe() {
        _meResult.value = MeItem(
            "Starbucks",
            "store",
            "https://freepngimg.com/thumb/starbucks/24318-4-starbucks-logo-photos.png"
        )
    }

}