package adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ui.onBoarding.onBoardingSlides.SlideOneFragment
import ui.onBoarding.onBoardingSlides.SlideTwoFragment
import util.Constant.CON_ON_BOARDING_SLIDES_COUNT
import java.lang.Exception


class OnBoardingPagerAdapter(
    fm: FragmentManager,
    private val onSkipClick: () -> Unit

) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 50
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0    -> SlideOneFragment()
            1    -> SlideTwoFragment()
            2    -> SlideOneFragment()
            else -> SlideOneFragment()
        }

    }


}