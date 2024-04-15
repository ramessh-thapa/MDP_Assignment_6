package com.example.sports_news_and_info_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


interface DialogCallback {
    fun onDataReturned(data: Any)
}

interface FragmentActions:DialogCallback {
    fun openDialog()
}

abstract class BaseFragment : Fragment(), FragmentActions {
}
class FragmentPageAdapter(supportFragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(supportFragmentManager) {
        private val fragments = ArrayList<BaseFragment>()
        private val fragmenttitles = ArrayList<String>()

        override fun getItem(position: Int): BaseFragment { return fragments[position] }

        override fun getCount(): Int { return fragments.size }

        override fun getPageTitle(position: Int): CharSequence{ return fragmenttitles[position] }

        fun addFragment(fragment: BaseFragment, title: String) {
            fragments.add(fragment)
            fragmenttitles.add(title)
        }
}
