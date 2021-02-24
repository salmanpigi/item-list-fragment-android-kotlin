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
        binding.apply {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            etShopDate.inputType = InputType.TYPE_NULL
            etShopDate.setOnClickListener(View.OnClickListener {
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

            btnSaveItem.setOnClickListener {
                if (etItemName.text.toString() != "" &&
                    etQty.text.toString() != "" &&
                    etNote.text.toString() != "" &&
                    etShopDate.text.toString() != ""
                ) {
                    val item = Item(
                        itemName = etItemName.text.toString(),
                        quantity = etQty.text.toString().toInt(),
                        note = etNote.text.toString(),
                        dateItem = etShopDate.text.toString()
                    )
                    viewModel.addItem(item)
                    clearInput()
                    Toast.makeText(activity, "Success add item", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Data must not be null", Toast.LENGTH_SHORT).show()
                }

            }}
        return binding.root
    }

    private fun clearInput() {
        binding.etItemName.setText("")
        binding.etQty.setText("")
        binding.etNote.setText("")
        binding.etShopDate.setText("")
    }
}
