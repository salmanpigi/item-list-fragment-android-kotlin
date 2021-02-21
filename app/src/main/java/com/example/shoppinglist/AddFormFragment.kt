package com.example.shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.shoppinglist.`interface`.ServiceInterface
import com.example.shoppinglist.enntities.Item
import com.example.shoppinglist.recycleview.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_add_form.*

class AddFormFragment(private val serviceInterface: ServiceInterface) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_save_item.setOnClickListener {
            val item = Item(
                itemName = et_item_name.text.toString(),
                quantity = et_qty.text.toString(),
                note = et_note.text.toString(),
                date = et_shopping_date.toString()
            )

            if (item != null) {
                serviceInterface.addItem(item)
                Toast.makeText(activity, "Success add data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(serviceInterface: ServiceInterface) =
            AddFormFragment(serviceInterface)
    }
}
