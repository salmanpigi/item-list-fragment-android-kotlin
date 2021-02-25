package com.example.shoppinglist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.enntities.Item

class ItemViewModel : ViewModel() {

    private var ListItem = mutableListOf<Item>();

    fun addItem(item: Item) {
        ListItem.add(item)
    }

    fun remove(i: Int) {
        ListItem.removeAt(i)
    }

    fun getItem(): MutableList<Item> {
        return ListItem
    }
}