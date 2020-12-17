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
            it.addSpaceItem(SpaceItem("HOME", R.mipmap.ic_launcher))
            it.addSpaceItem(SpaceItem("SEARCH", R.mipmap.ic_launcher))
            it.shouldShowFullBadgeText(true)
            it.setCentreButtonIconColorFilterEnabled(false)
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
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}