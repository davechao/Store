package com.swiper.store.ui.voucher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swiper.store.R
import com.swiper.store.model.vo.VoucherItem
import kotlinx.android.synthetic.main.item_voucher.view.*

class VoucherAdapter(
    private val vouchers: List<VoucherItem>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_voucher, parent, false)
        return VoucherViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = vouchers[position]

        holder as VoucherViewHolder
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return vouchers.size
    }

    class VoucherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.tv_title
    }
}