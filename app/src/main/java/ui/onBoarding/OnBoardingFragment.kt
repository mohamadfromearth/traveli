package ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class OnBoardingFragment : BaseFragment<FragmentOnboardingBinding, OnBoardingEvent, OnBoardingAction, OnBoardingViewModel>(R.layout.fragment_onboarding) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: OnBoardingViewModel by viewModels()
        initialize(viewModel)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}



