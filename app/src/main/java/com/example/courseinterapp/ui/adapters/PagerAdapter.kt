package com.example.courseinterapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.courseinterapp.ui.FirstGraphFragment
import com.example.courseinterapp.ui.FragmentMembers
import com.example.courseinterapp.ui.ListUserFragment
import com.example.courseinterapp.ui.ThirdFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentMembers()
            1 -> ListUserFragment()
            else -> ThirdFragment()
        }
    }


}