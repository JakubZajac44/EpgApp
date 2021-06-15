package pl.proexe.junior.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import pl.proexe.junior.view.tvProgrammeList.TvProgrammeListFragment

class FragmentListCollectionAdapter(fragment: Fragment, private val itemTabCount: Int) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = itemTabCount

    override fun createFragment(position: Int): Fragment {
        val fragment = TvProgrammeListFragment()
        fragment.arguments = Bundle().apply {
        }
        return fragment
    }
}