package com.example.shoppinglist.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.ItemList
import com.example.shoppinglist.R

class RecyclerAdapter(): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemQty: TextView
        var itemNote: TextView
        var itemDate: TextView

        init {
            itemName = itemView.findViewById(R.id.cv_itemName)
            itemQty = itemView.findViewById(R.id.cv_qty)
            itemNote = itemView.findViewById(R.id.cv_note)
            itemDate = itemView.findViewById(R.id.cv_shop_date)

//            itemView.setOnClickListener {
//                var position: Int = adapterPosition
//                val context = itemView.context
//                val intent = Intent(context, DetailPertanyaan::class.java).apply {
//                    putExtra("NUMBER", position)
//                    putExtra("CODE", itemKode.text)
//                    putExtra("CATEGORY", itemKategori.text)
//                    putExtra("CONTENT", itemIsi.text)
//                }
//                context.startActivity(intent)
//            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = ItemList[i].itemName
        viewHolder.itemQty.text = ItemList[i].quantity
        viewHolder.itemNote.text = ItemList[i].note
        viewHolder.itemDate.text = ItemList[i].date
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

}