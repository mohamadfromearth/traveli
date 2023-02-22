package ui.onBoarding.onBoardingSlides

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentOnboardingSlideOneBinding

class SlideOneFragment : Fragment() {

    private var _binding: FragmentOnboardingSlideOneBinding? = null
    private val binding: FragmentOnboardingSlideOneBinding
        get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_onboarding_slide_one,container,false)
        return binding.root
    }


}