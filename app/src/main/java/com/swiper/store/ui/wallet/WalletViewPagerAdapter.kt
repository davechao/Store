package com.swiper.store.ui.wallet

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.swiper.store.ui.currencyrecord.CurrencyRecordFragment
import com.swiper.store.ui.voucher.VoucherFragment

class WalletViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CurrencyRecordFragment()
            else ->  VoucherFragment()
        }
    }

}