package com.swiper.store.ui.currencyrecord

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.model.repository.ApiRepository
import com.swiper.store.model.vo.CurrencyRecordItem
import com.swiper.store.ui.base.BaseViewModel

class CurrencyRecordViewModel @ViewModelInject constructor(
    private var apiRepository: ApiRepository
) : BaseViewModel() {

    private val _currencyRecordResult = MutableLiveData<List<CurrencyRecordItem>>()
    val currencyRecordResult: LiveData<List<CurrencyRecordItem>> = _currencyRecordResult

    fun getCurrencyRecords() {
        _currencyRecordResult.value = apiRepository.fetchCurrencyRecords()
    }
}