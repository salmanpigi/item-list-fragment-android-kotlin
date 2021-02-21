package com.example.shoppinglist.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class RecyclerAdapter(var nameItem: ArrayList<String>, var date: ArrayList<String>,
                      var qty: ArrayList<String>, var note: ArrayList<String>)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    constructor(){}

    private var shopDates = arrayListOf<String>("12-12-2012", "11-11-2011", "10-10-2010", "09-09-2009")
    private var itemNames = arrayListOf<String>("Jeruk", "Semangka", "Salak", "Melon")
    private var qtys = arrayListOf<String>("120", "110", "110", "90")
    private var notes = arrayListOf<String>("aaa", "bbb", "ccc", "ddd")


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
        viewHolder.itemName.text = itemNames[i]
        viewHolder.itemQty.text = qtys[i]
        viewHolder.itemNote.text = notes[i]
        viewHolder.itemDate.text = shopDates[i]
    }

    override fun getItemCount(): Int {
        return qtys.size
    }

}