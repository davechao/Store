package com.swiper.store.ui.currencyrecord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.swiper.store.R
import com.swiper.store.ui.base.BaseFragment

class CurrencyRecordFragment : BaseFragment() {

    private val viewModel: CurrencyRecordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_currency_record
    }
}