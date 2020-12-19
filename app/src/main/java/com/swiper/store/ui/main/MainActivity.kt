package com.swiper.store.ui.main

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceOnClickListener
import com.swiper.store.R
import com.swiper.store.ui.base.BaseActivity
import com.swiper.store.ui.chat.ChatFragment
import com.swiper.store.ui.explore.ExploreFragment
import com.swiper.store.ui.phone.PhoneFragment
import com.swiper.store.ui.wallet.WalletFragment
import com.swiper.store.widget.utility.GeneralUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    companion object {
        const val ITEM_PHONE = "PHONE"
        const val ITEM_CHAT = "CHAT"
        const val ITEM_EXPLORE = "EXPLORE"
        const val ITEM_WALLET = "WALLET"
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        space_navigation_view.also {
            it.initWithSaveInstanceState(savedInstanceState)
            it.addSpaceItem(SpaceItem(ITEM_PHONE, R.drawable.ic_outline_phone_24))
            it.addSpaceItem(SpaceItem(ITEM_CHAT, R.drawable.ic_outline_chat_24))
            it.addSpaceItem(SpaceItem(ITEM_EXPLORE, R.drawable.ic_outline_explore_24))
            it.addSpaceItem(SpaceItem(ITEM_WALLET, R.drawable.ic_outline_account_balance_wallet_24))

            it.shouldShowFullBadgeText(false)
            it.showIconOnly()

            it.setSpaceOnClickListener(object : SpaceOnClickListener {
                override fun onCentreButtonClick() {
                    GeneralUtils.showToast(this@MainActivity, "Scan")
                }

                override fun onItemClick(itemIndex: Int, itemName: String?) {
                    when (itemName) {
                        ITEM_PHONE -> navigateTo(PhoneFragment())
                        ITEM_CHAT -> navigateTo(ChatFragment())
                        ITEM_EXPLORE -> navigateTo(ExploreFragment())
                        ITEM_WALLET -> navigateTo(WalletFragment())
                    }
                }

                override fun onItemReselected(itemIndex: Int, itemName: String?) {

                }
            })
        }

        navigateTo(PhoneFragment())

        viewModel.badgeResult.observe(this, {
            space_navigation_view.also { navigationView ->
                navigationView.shouldShowFullBadgeText(true)
                navigationView.showBadgeAtIndex(3, it, Color.RED)
            }
        })

        lifecycleScope.launch {
            delay(500)
            viewModel.fetchBadge()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private fun navigateTo(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout_fragment, fragment).commit()
    }
}