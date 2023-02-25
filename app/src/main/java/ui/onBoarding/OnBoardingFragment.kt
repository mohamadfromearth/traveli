package ui.onBoarding

import adapter.OnBoardingPagerAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

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


    }

    private fun setUpOnBoardingPager() {

        onBoardingPagerAdapter = OnBoardingPagerAdapter(parentFragmentManager, onSkipClick = {})
        binding.pager.adapter = onBoardingPagerAdapter
    }


}



