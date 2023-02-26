package adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ui.base.BaseActivity
import ui.onBoarding.OnBoardingPagerFragment
import util.Constant.CON_ON_BOARDING_SLIDES_COUNT
import util.Constant.KEY_ON_BOARDING_POSITION


class OnBoardingPagerAdapter(
    fm: FragmentManager,
    private val baseActivity: BaseActivity,
    private val onSkipClick: () -> Unit


) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    private val items = mutableListOf<Fragment>()

    init {
        for (i in 0 until CON_ON_BOARDING_SLIDES_COUNT){

            items.add(OnBoardingPagerFragment().apply {
                val bundle = Bundle().apply { putInt(KEY_ON_BOARDING_POSITION,i) }
                arguments = bundle
            })
        }
    }
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {

      return items[position]

    }


}