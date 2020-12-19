package com.swiper.store.ui.currencyrecord

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swiper.store.R
import com.swiper.store.model.vo.CurrencyRecordItem
import kotlinx.android.synthetic.main.item_ad.view.*
import kotlinx.android.synthetic.main.item_currency_record.view.*
import timber.log.Timber
import java.lang.StringBuilder

class CurrencyRecordAdapter(
    private val records: List<CurrencyRecordItem>,
    private val funcListener: CurrencyRecodeFuncListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_AD = 0
        const val VIEW_TYPE_RECORD = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_RECORD -> {
                val mView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_currency_record, parent, false)
                CurrencyRecordViewHolder(mView)
            }
            else -> {
                val mView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_ad, parent, false)
                AdViewHolder(mView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = records[position]
        return if (item.adItem != null) VIEW_TYPE_AD
        else VIEW_TYPE_RECORD
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = records[position]
        when (holder) {
            is CurrencyRecordViewHolder -> {
                Glide.with(holder.currencyImg.context)
                    .load(item.currencyImg)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.currencyImg)

                if (item.currency.indexOf(".") > 0) {
                    val currencyArray = item.currency.split(".")
                    if (!TextUtils.isEmpty(currencyArray[0])) {
                        holder.currencyText.text = currencyArray[0]
                    }
                    if (!TextUtils.isEmpty(currencyArray[1])) {
                        holder.subCurrencyText.text = StringBuilder(".")
                            .append(currencyArray[1])
                            .toString()
                    }
                } else {
                    holder.currencyText.text = item.currency
                }

                holder.walletText.text = item.wallet
                holder.progressDate.progress = ((item.day / 365f) * 100).toInt()
                holder.interactionRewardsText.text = item.interactionRewards
                holder.socialRewardsText.text = item.socialRewards
                holder.revenueText.text = item.revenue
                holder.dateText.text = StringBuilder(item.day.toString())
                    .append(" ")
                    .append(holder.dateText.context.getString(R.string.expired_day))
                    .toString()

                holder.recordDetailText.setOnClickListener {
                    funcListener.onDetailClick()
                }
            }
            is AdViewHolder -> {
                Glide.with(holder.adImg.context)
                    .load(item.adItem?.img)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.adImg)

                holder.adTitle.text = item.adItem?.title
                holder.adSubTitle.text = item.adItem?.subTitle
            }
        }
    }

    override fun getItemCount(): Int {
        return records.size
    }

    class CurrencyRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currencyImg: ImageView = itemView.iv_currency
        var walletText: TextView = itemView.tv_wallet
        var currencyText: TextView = itemView.tv_currency_value
        var subCurrencyText: TextView = itemView.tv_sub_currency_value
        var progressDate: ProgressBar = itemView.pb_date
        var dateText: TextView = itemView.tv_date
        var interactionRewardsText: TextView = itemView.tv_interaction_rewards_value
        var socialRewardsText: TextView = itemView.tv_social_rewards_value
        var revenueText: TextView = itemView.tv_revenue_value
        var recordDetailText: TextView = itemView.tv_record_detail
    }

    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var adImg: ImageView = itemView.iv_ad
        var adTitle: TextView = itemView.tv_ad_title
        var adSubTitle: TextView = itemView.tv_ad_subtitle
    }
}