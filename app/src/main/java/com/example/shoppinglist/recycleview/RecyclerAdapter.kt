package com.example.shoppinglist.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.enntities.Item

class RecyclerAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.cv_itemName)
        var itemQty: TextView = itemView.findViewById(R.id.cv_qty)
        var itemNote: TextView = itemView.findViewById(R.id.cv_note)
        var itemDate: TextView = itemView.findViewById(R.id.cv_shop_date)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = items[i].itemName
        viewHolder.itemQty.text = items[i].quantity.toString()
        viewHolder.itemNote.text = items[i].note
        viewHolder.itemDate.text = items[i].dateItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}