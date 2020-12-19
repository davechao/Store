package com.swiper.store.ui.voucher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swiper.store.model.vo.VoucherItem
import com.swiper.store.ui.base.BaseViewModel

class VoucherViewModel : BaseViewModel() {

    private val _voucherItemResult = MutableLiveData<List<VoucherItem>>()
    val voucherItemResult: LiveData<List<VoucherItem>> = _voucherItemResult

    fun getVouchers() {
        val list = arrayListOf<VoucherItem>()

        for (i in 0..20) {
            list.add(VoucherItem("Voucher$i"))
        }

        _voucherItemResult.value = list
    }
}