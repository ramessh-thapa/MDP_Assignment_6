package com.example.sports_news_and_info_app.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.adapters.FragmentPageAdapter
import com.example.sports_news_and_info_app.fragments.AboutMeFragment
import com.example.sports_news_and_info_app.fragments.AthleteFragment
import com.example.sports_news_and_info_app.fragments.EventFragment
import com.example.sports_news_and_info_app.fragments.HistoricalEventFragment
import com.example.sports_news_and_info_app.fragments.NewsFragment
//import com.example.sports_news_and_info_app.fragments.NewsFragment
import com.example.sports_news_and_info_app.fragments.SportsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabs)
        floatingActionButton = findViewById(R.id.fab_add)
        bottomNavigationView = findViewById(R.id.bottomNav)

        val adapter = FragmentPageAdapter(supportFragmentManager)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_news -> {
                    tabLayout.selectTab(tabLayout.getTabAt(1))
                    true
                }
                R.id.navigation_event -> {
                    tabLayout.selectTab(tabLayout.getTabAt(3))
                    true
                }
                R.id.navigation_historical_archive -> {
                    tabLayout.selectTab(tabLayout.getTabAt(4))
                    true
                }
                else -> true
            }
        }

        floatingActionButton.setOnClickListener {
            val selectedFragment = tabLayout.selectedTabPosition
            print("selected Fragment: $selectedFragment")
            adapter.getItem(selectedFragment).openDialog()
        }

        adapter.addFragment(SportsFragment(), "Sports")
        adapter.addFragment(NewsFragment(), "News")
        adapter.addFragment(AthleteFragment(), "Athletes")
        adapter.addFragment(EventFragment(), "Events")
        adapter.addFragment(HistoricalEventFragment(), "Historical Archives")
        adapter.addFragment(AboutMeFragment(), "About Me")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 5) {
                    floatingActionButton.visibility = View.GONE
                } else {
                    floatingActionButton.visibility = View.VISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}
