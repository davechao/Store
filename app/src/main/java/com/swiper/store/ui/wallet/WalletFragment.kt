package com.swiper.store.ui.wallet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.swiper.store.R
import com.swiper.store.ui.base.BaseFragment
import com.swiper.store.widget.utility.GeneralUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_wallet.*

@AndroidEntryPoint
class WalletFragment : BaseFragment() {

    private val viewModel: WalletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabs = arrayListOf(
            getString(R.string.currency_record),
            getString(R.string.voucher) + " (2)",
        )

        iv_notification.setOnClickListener {
            GeneralUtils.showToast(requireContext(), "Notification Click!")
        }

        iv_settings.setOnClickListener {
            GeneralUtils.showToast(requireContext(), "Settings Click!")
        }

        tv_code.setOnClickListener {
            GeneralUtils.showToast(requireContext(), getString(R.string.promotion_code))
        }

        tv_e_commerce.setOnClickListener {
            GeneralUtils.showToast(requireContext(), getString(R.string.e_commerce))
        }

        tv_mall.setOnClickListener {
            GeneralUtils.showToast(requireContext(), getString(R.string.mall))
        }

        viewpager.adapter = WalletViewPagerAdapter(this)

        TabLayoutMediator(layout_tab, viewpager) { tab, position ->
            tab.text = tabs[position]
        }.attach()

        viewModel.meResult.observe(viewLifecycleOwner, {
            tv_name.text = it.name
            tv_tag.text = it.tag

            Glide.with(this)
                .load(it.avatar)
                .error(R.mipmap.ic_launcher_round)
                .into(iv_avatar)
        })

        viewModel.getMe()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wallet
    }
}