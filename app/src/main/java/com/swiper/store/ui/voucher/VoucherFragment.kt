package com.swiper.store.ui.voucher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.swiper.store.R
import com.swiper.store.ui.base.BaseFragment

class VoucherFragment : BaseFragment() {

    private val viewModel: VoucherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_voucher
    }
}