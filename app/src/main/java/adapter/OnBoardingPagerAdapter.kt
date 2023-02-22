package adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingPagerAdapter(
    fm: FragmentManager,
    lifeCycle: Lifecycle,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(fm, lifeCycle) {
    override fun getItemCount(): Int {
        return fragments.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}