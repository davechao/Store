package com.swiper.store.ui.currencyrecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.model.vo.AdItem
import com.swiper.store.model.vo.CurrencyRecordItem
import com.swiper.store.ui.base.BaseViewModel

class CurrencyRecordViewModel : BaseViewModel() {

    private val _currencyRecordResult = MutableLiveData<List<CurrencyRecordItem>>()
    val currencyRecordResult: LiveData<List<CurrencyRecordItem>> = _currencyRecordResult

    fun getCurrencyRecords() {
        val list = arrayListOf<CurrencyRecordItem>()
        val recordItem = CurrencyRecordItem(
            "https://cdn3.iconfinder.com/data/icons/currency-and-cryptocurrency-signs/64/cryptocurrency_blockchain_Bitcoin_BTC-512.png",
            "9,102,619.123",
            "XNC(無限錢包)",
            328,
            "+1.849",
            "+681.213",
            "+1,793.729"
        )
        val adItem = CurrencyRecordItem(
            adItem = AdItem(
                "https://ddo0fzhfvians.cloudfront.net/uploads/icons/png/129749061547464088-512.png",
                "2019 中台灣元宵燈會-福滿迎豬, 燈會限定, 網美必拍!",
                "台中市政府"
            )
        )
        list.add(recordItem)
        list.add(adItem)
        _currencyRecordResult.value = list
    }

}