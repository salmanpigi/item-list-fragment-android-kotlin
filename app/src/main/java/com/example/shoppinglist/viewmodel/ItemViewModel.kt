package com.example.shoppinglist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.enntities.Item

class ItemViewModel : ViewModel() {

    private val TAG = "ItemViewModel"

    private var ListItem = mutableListOf<Item>();

    fun addItem(item: Item) {
        ListItem.add(item)
    }

    fun getItem(): MutableList<Item> {
        return ListItem
    }
}