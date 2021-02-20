package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var formFragment: AddFormFragment
    private lateinit var itemListFragment: ItemListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_createItem.setOnClickListener(this)
        btn_listItem.setOnClickListener(this)

        formFragment = AddFormFragment()
        itemListFragment = ItemListFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, itemListFragment).commit()

    }

    override fun onClick(v: View?) {
        when (v) {
            btn_listItem -> {
                switchFragment(itemListFragment)
            }
            btn_createItem -> {
                switchFragment(formFragment)
            }
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}