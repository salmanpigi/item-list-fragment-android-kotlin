package com.example.shoppinglist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shoppinglist.`interface`.ItemService
import com.example.shoppinglist.recycleview.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_add_form.*

class AddFormFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_save_item.setOnClickListener {
            RecyclerAdapter(txt_itemName.text.toString(), txt_shoppingDate.text.toString(),
                txt_qty.text.toString(), txt_notes.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_form, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddFormFragment()
    }
}
