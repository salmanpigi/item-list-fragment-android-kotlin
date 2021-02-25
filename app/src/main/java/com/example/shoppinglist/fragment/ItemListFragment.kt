package com.example.shoppinglist.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.databinding.FragmentItemListBinding
import com.example.shoppinglist.recycleview.RecyclerAdapter
import com.example.shoppinglist.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_item_list.*


class ItemListFragment : Fragment() {

    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentItemListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_item.apply {
            layoutManager = LinearLayoutManager(activity)
            val items = viewModel.getItem()
            adapter = RecyclerAdapter(items)
        }
    }
}