package com.swiper.store.model.repository

import com.swiper.store.model.vo.AdItem
import com.swiper.store.model.vo.CurrencyRecordItem
import com.swiper.store.model.vo.MeItem
import com.swiper.store.model.vo.VoucherItem

class ApiRepository {

    fun fetchMe(): MeItem {
        return MeItem(
            "Starbucks",
            "store",
            "https://freepngimg.com/thumb/starbucks/24318-4-starbucks-logo-photos.png"
        )
    }

    fun fetchCurrencyRecords(): List<CurrencyRecordItem> {
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
                "2020 聖誕景點 - 台北101、信義新天地絕美聖誕樹，年末就來拍好拍滿！",
                "台北市政府"
            )
        )
        list.add(recordItem)
        list.add(adItem)
        return list
    }

    fun fetchVouchers(): List<VoucherItem> {
        val list = arrayListOf<VoucherItem>()
        for (i in 0..20) {
            list.add(VoucherItem("Voucher$i"))
        }
        return list
    }

}