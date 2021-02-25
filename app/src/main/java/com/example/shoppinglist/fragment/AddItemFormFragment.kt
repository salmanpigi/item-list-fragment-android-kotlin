package com.example.shoppinglist.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.shoppinglist.LoadingDialog
import com.example.shoppinglist.ResourceStatus
import com.example.shoppinglist.databinding.FragmentAddItemFormBinding
import com.example.shoppinglist.viewmodel.ItemViewModel
import java.util.*

class AddItemFormFragment : Fragment() {

    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentAddItemFormBinding
    lateinit var loadingDialog: androidx.appcompat.app.AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        subscribe()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentAddItemFormBinding.inflate(layoutInflater)
        binding.apply {

            etShopDate.onCreateDate()

            btnSaveItem.setOnClickListener {
                val name = etItemName.text.toString()
                val qty = etQty.text.toString()
                val note = etNote.text.toString()
                val date = etShopDate.text.toString()
                viewModel.inputValidation(name, qty, note, date)
                clearInput()
            }
        }
        return binding.root
    }

    private fun clearInput() {
        binding.etItemName.setText("")
        binding.etQty.setText("")
        binding.etNote.setText("")
        binding.etShopDate.setText("")
    }

    private fun EditText.onCreateDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        this.inputType = InputType.TYPE_NULL
        this.setOnClickListener(View.OnClickListener {
            val datePickerDialog = activity?.let { it ->
                DatePickerDialog(
                    it, DatePickerDialog.OnDateSetListener
                    { view, year, monthOfYear, dayOfMonth ->
                        this.setText(
                            "$year/$monthOfYear/$dayOfMonth",
                            TextView.BufferType.EDITABLE
                        );
                    }, year, month, day
                )
            }
            datePickerDialog?.show()
        })
    }

    private fun subscribe() {
        viewModel.isValid.observe(requireActivity()) {
            when (it.status) {
                ResourceStatus.LOADING -> loadingDialog.show()
                ResourceStatus.SUCCESS -> {
                    loadingDialog.hide()
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
                ResourceStatus.FAIL -> {
                    loadingDialog.hide()
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
