package com.swiper.store.ui.currencyrecord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.swiper.store.R
import com.swiper.store.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_currency_record.*

class CurrencyRecordFragment : BaseFragment() {

    private val viewModel: CurrencyRecordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currencyRecordResult.observe(viewLifecycleOwner, {
            rv_currency_record.adapter = CurrencyRecordAdapter(it)
        })

        viewModel.getCurrencyRecord()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_currency_record
    }
}