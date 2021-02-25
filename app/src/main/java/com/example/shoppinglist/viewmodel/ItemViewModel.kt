package com.example.shoppinglist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.ResourceState
import com.example.shoppinglist.enntities.Item
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {

    var liveData: MutableLiveData<String> = MutableLiveData()

    private var ListItem = mutableListOf<Item>();

    var _isValid = MutableLiveData<ResourceState>()
    val isValid: LiveData<ResourceState>
        get() {
            return _isValid
        }

    fun addItem(name: String, qty: String, note: String, date: String) {
        val item = Item(name, qty, note, date)
        ListItem.add(item)
    }

    fun remove(i: Int) {
        ListItem.removeAt(i)
    }

    fun getItem(): MutableList<Item> {
        return ListItem
    }

    // untuk validasi input pada Form Fragment
    fun inputValidation(name: String, qty: String, note: String, date: String) {
        GlobalScope.launch {
            _isValid.postValue(ResourceState.loading())
            delay(3000)
            if (!name.isNullOrBlank() || !qty.isNullOrBlank() || !note.isNullOrBlank() || !date.isNullOrBlank()) {
                addItem(name, qty, note, date)
                _isValid.postValue(ResourceState.success(true, "Success add $name"))

            } else {
                _isValid.postValue(ResourceState.fail("Form must not be null"))
            }
        }
    }
}