package com.swiper.store.ui.voucher

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.model.repository.ApiRepository
import com.swiper.store.model.vo.VoucherItem
import com.swiper.store.ui.base.BaseViewModel

class VoucherViewModel @ViewModelInject constructor(
    private var apiRepository: ApiRepository
) : BaseViewModel() {

    private val _voucherItemResult = MutableLiveData<List<VoucherItem>>()
    val voucherItemResult: LiveData<List<VoucherItem>> = _voucherItemResult

    fun getVouchers() {
        _voucherItemResult.value = apiRepository.fetchVouchers()
    }
}