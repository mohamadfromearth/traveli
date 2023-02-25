package ui.onBoarding.onBoardingSlides

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentSlideOneBinding

class SlideOneFragment() : Fragment() {


    private var _binding: FragmentSlideOneBinding? = null
    private val binding: FragmentSlideOneBinding
        get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_slide_one, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}