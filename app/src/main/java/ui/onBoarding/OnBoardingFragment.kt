package ui.onBoarding

import adapter.OnBoardingPagerAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.extension.log

@AndroidEntryPoint
class OnBoardingFragment : BaseFragment<FragmentOnboardingBinding, OnBoardingEvent, OnBoardingAction, OnBoardingViewModel>(R.layout.fragment_onboarding) {

    private lateinit var onBoardingPagerAdapter: OnBoardingPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: OnBoardingViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOnBoardingPager()
        binding.pager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if (position % 2 == 0) {
                    binding.pager.setButtonDrawable(R.drawable.ic_arrow_left_white)

                } else {
                    binding.pager.setButtonDrawable(R.drawable.ic_arrow_left_black)
                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })


    }

    private fun setUpOnBoardingPager() {
        onBoardingPagerAdapter = OnBoardingPagerAdapter(parentFragmentManager, onSkipClick = {}, baseActivity = baseActivity)
        binding.pager.adapter = onBoardingPagerAdapter
    }


}



