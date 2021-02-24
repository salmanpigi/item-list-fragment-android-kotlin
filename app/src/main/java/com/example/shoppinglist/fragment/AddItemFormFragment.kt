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
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.databinding.FragmentAddItemFormBinding
import com.example.shoppinglist.enntities.Item
import com.example.shoppinglist.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_add_item_form.*
import java.util.*

class AddItemFormFragment : Fragment() {

    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentAddItemFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemFormBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            et_shop_date.setInputType(InputType.TYPE_NULL)
            et_shop_date.setOnClickListener(View.OnClickListener {
                val datePickerDialog = activity?.let { it ->
                    DatePickerDialog(
                        it, DatePickerDialog.OnDateSetListener
                        { view, year, monthOfYear, dayOfMonth ->
                            etShopDate.setText(
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
                    etShopDate.text.toString() != ""
                ) {
                    val item = Item(
                        itemName = et_item_name.text.toString(),
                        quantity = et_qty.text.toString(),
                        note = et_note.text.toString(),
                        dateItem = etShopDate.text.toString()
                    )
                    viewModel.addItem(item)
//                    clearInput()
                    Toast.makeText(activity, "Success add data", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Data must not be null", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

//    private fun clearInput() {
//        binding.etItemName.setText("")
//        binding.etQty.setText("")
//        binding.etNote.setText("")
//        binding.etShopDate.setText("")
//    }
}
