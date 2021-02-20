package com.example.shoppinglist

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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

//        bottom_navigation.setOnNavigationItemSelectedListener(navListener)

    }

//    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            var selectedFragment: Fragment? = null
//            when (item.itemId) {
//                nav -> selectedFragment = HomeFragment()
//                R.id.nav_favorites -> selectedFragment = FavoritesFragment()
//                R.id.nav_search -> selectedFragment = SearchFragment()
//            }
//            supportFragmentManager.beginTransaction().replace(
//                R.id.fragment_container,
//                selectedFragment!!
//            ).commit()
//            true
//        }

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