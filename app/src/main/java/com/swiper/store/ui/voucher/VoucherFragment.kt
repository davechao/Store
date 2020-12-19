package com.swiper.store.ui.voucher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.swiper.store.R
import com.swiper.store.ui.base.BaseFragment
import com.swiper.store.ui.currencyrecord.CurrencyRecordAdapter
import kotlinx.android.synthetic.main.fragment_currency_record.*
import kotlinx.android.synthetic.main.fragment_currency_record.rv_currency_record
import kotlinx.android.synthetic.main.fragment_voucher.*

class VoucherFragment : BaseFragment() {

    private val viewModel: VoucherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.voucherItemResult.observe(viewLifecycleOwner, {
            rv_voucher.setHasFixedSize(true)
            rv_voucher.adapter = VoucherAdapter(it)
        })

        viewModel.getVouchers()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_voucher
    }
}