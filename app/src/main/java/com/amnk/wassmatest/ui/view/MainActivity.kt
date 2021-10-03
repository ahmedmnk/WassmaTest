package com.amnk.wassmatest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.amnk.wassmatest.R
import com.amnk.wassmatest.ui.view.Adapters.viewPagerAdapter
import com.amnk.wassmatest.ui.view.fragments.ImagesFragment
import com.amnk.wassmatest.ui.view.fragments.PostsFragment
import com.amnk.wassmatest.ui.view.fragments.favoritesFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabs()
    }

    private fun setupTabs()
    {
        val vp =  findViewById<ViewPager?>(R.id.viewPager)
        val tb =  findViewById<TabLayout?>(R.id.tabLayoutParent)
        val adapter = viewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PostsFragment(),"Posts")
        adapter.addFragment(ImagesFragment(),"Images")
        adapter.addFragment(favoritesFragment(),"Favorites")
        vp.adapter = adapter
        tb.setupWithViewPager(vp)

    }

}