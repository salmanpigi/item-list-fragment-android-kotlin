package com.example.shoppinglist.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shoppinglist.utils.ItemList
import com.example.shoppinglist.R
import com.example.shoppinglist.enntities.Item
import kotlinx.android.synthetic.main.fragment_add_form.*
import java.util.*

class AddFormFragment : Fragment() {

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

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        et_shopping_date.setInputType(InputType.TYPE_NULL)
        et_shopping_date.setOnClickListener(View.OnClickListener {
            val datePickerDialog = activity?.let { it1 ->
                DatePickerDialog(
                    it1, DatePickerDialog.OnDateSetListener
                    { view, year, monthOfYear, dayOfMonth ->
                        et_shopping_date.setText(
                            "$year/$monthOfYear/$dayOfMonth",
                            TextView.BufferType.EDITABLE
                        );
                    }, year, month, day
                )
            }
            datePickerDialog?.show()
        })

        btn_save_item.setOnClickListener {
            if (et_item_name.text.toString() != "" &&
                et_qty.text.toString() != "" &&
                et_note.text.toString() != "" &&
                et_shopping_date.text.toString() != ""
            ) {
                val item = Item(
                    itemName = et_item_name.text.toString(),
                    quantity = et_qty.text.toString(),
                    note = et_note.text.toString(),
                    dateItem = et_shopping_date.text.toString()
                )
                ItemList.add(item)
                Toast.makeText(activity, "Success add data", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Data must not be null", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
