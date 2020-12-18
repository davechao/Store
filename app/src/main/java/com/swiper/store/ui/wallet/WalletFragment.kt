package com.swiper.store.ui.wallet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.swiper.store.R
import com.swiper.store.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_wallet.*

class WalletFragment : BaseFragment() {

    private val viewModel: WalletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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