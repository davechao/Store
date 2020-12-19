package com.swiper.store.model.vo

data class CurrencyRecordItem(
    val currencyImg: String = "",
    val currency: String = "",
    val wallet: String = "",
    val day: Int = 0,
    val interactionRewards: String = "",
    val socialRewards: String = "",
    val revenue: String = "",
    val adItem: AdItem? = null
)