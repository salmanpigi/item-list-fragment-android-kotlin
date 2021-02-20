package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var formFragment: AddFormFragment
    private lateinit var itemListFragment: ItemListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formFragment = AddFormFragment()
        itemListFragment = ItemListFragment()

        switchFragment(itemListFragment)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_add -> switchFragment(itemListFragment)
                R.id.nav_itemList -> switchFragment(formFragment)
            }
            true
        }
    }


    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}