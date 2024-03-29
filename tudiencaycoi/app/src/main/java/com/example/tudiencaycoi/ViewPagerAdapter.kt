package com.example.tudiencaycoi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    //ctrl + i
    override fun getItemCount(): Int {
        return 4
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                Fragment1()
            }
            1->{
                Fragment2()
            }
            2->{
                Fragment3()
            }
            else->{
                Fragment4()
            }
        }
    }
}