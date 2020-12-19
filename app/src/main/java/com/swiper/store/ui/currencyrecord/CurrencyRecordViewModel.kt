package com.swiper.store.ui.currencyrecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.model.vo.AdItem
import com.swiper.store.model.vo.CurrencyRecordItem
import com.swiper.store.ui.base.BaseViewModel

class CurrencyRecordViewModel : BaseViewModel() {

    private val _currencyRecordResult = MutableLiveData<List<CurrencyRecordItem>>()
    val currencyRecordResult: LiveData<List<CurrencyRecordItem>> = _currencyRecordResult


    fun getCurrencyRecord() {
        val list = arrayListOf<CurrencyRecordItem>()
        val item = CurrencyRecordItem(
            "https://upload.wikimedia.org/wikipedia/commons/6/6f/Ethereum-icon-purple.svg",
            "9,102,619.123",
            "XNC(無限錢包)",
            328,
            "+1.849",
            "+681.213",
            "+1,793.729"
        )
        val item2 = CurrencyRecordItem(
            adItem = AdItem(
                "https://ddo0fzhfvians.cloudfront.net/uploads/icons/png/129749061547464088-512.png",
                "2019 中台灣元宵燈會-福滿迎豬, 燈會限定, 網美必拍!",
                "台中市政府"
            )
        )
        list.add(item)
        list.add(item2)
        _currencyRecordResult.value = list
    }

}