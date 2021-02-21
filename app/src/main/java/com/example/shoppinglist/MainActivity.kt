package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shoppinglist.`interface`.ServiceInterface
import com.example.shoppinglist.enntities.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ServiceInterface {

    private lateinit var formFragment: AddFormFragment
    private lateinit var itemListFragment: ItemListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formFragment = AddFormFragment(this)
        itemListFragment = ItemListFragment()

        bottom_nav.menu.getItem(1).isChecked= true
        switchFragment(itemListFragment)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_add -> switchFragment(formFragment)
                R.id.nav_itemList -> switchFragment(itemListFragment)
            }
            true
        }
    }


    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun addItem(item: Item) {
        ItemList.add(item)
    }
}