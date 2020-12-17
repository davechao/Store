package com.swiper.store.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceOnClickListener
import com.swiper.store.R
import com.swiper.store.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        space_navigation_view.also {
            it.initWithSaveInstanceState(savedInstanceState)
            it.addSpaceItem(SpaceItem("PHONE", R.drawable.ic_outline_phone_24))
            it.addSpaceItem(SpaceItem("CHAT", R.drawable.ic_outline_chat_24))
            it.addSpaceItem(SpaceItem("EXPLORE", R.drawable.ic_outline_explore_24))
            it.addSpaceItem(SpaceItem("WALLET", R.drawable.ic_outline_account_balance_wallet_24))

            it.shouldShowFullBadgeText(false)
            it.setCentreButtonIconColorFilterEnabled(false)
            it.showIconOnly()

            it.setSpaceOnClickListener(object : SpaceOnClickListener {
                override fun onCentreButtonClick() {
                    it.shouldShowFullBadgeText(true)
                }

                override fun onItemClick(itemIndex: Int, itemName: String?) {

                }

                override fun onItemReselected(itemIndex: Int, itemName: String?) {

                }
            })
        }

//        space_navigation_view.shouldShowFullBadgeText(true)
//        space_navigation_view.showBadgeAtIndex(3, 1, Color.RED)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}