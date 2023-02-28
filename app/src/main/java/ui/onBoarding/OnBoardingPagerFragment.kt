package ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentOnBoardingSlidesBinding
import main.ApplicationClass
import util.Constant.KEY_ON_BOARDING_POSITION
import util.extension.log
import util.getColor

class OnBoardingPagerFragment() : Fragment() {
    private var _binding: FragmentOnBoardingSlidesBinding? = null
    private val binding: FragmentOnBoardingSlidesBinding
        get() = _binding!!
    private val app = ApplicationClass.getInstance()
    private var position: Int? = -1
    private var cityImage = 0
    private var travelyLogo = 0
    private var title1Text = ""
    private var title2Text = ""
    private var descriptionText = ""
    private var textColor = 0
    private var backgroundColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = arguments?.getInt(KEY_ON_BOARDING_POSITION)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_slides, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        log("position")

        binding.apply {
            initialDataByPosition()
            loadImages()
            setUpTextViews()
            setUpOnClickListener()
            view.setBackgroundColor(backgroundColor)
        }
    }

    private fun initialDataByPosition() {
        position?.let {
            when (it) {
                0 -> {
                    cityImage = R.drawable.london
                    title1Text = app.m.firstSlideTitle1
                    title2Text = app.m.firstSlideTitle2
                    descriptionText = app.m.firstSlideDescription
                    backgroundColor = getColor(R.color.lightPinkBackground0)
                    textColor = getColor(R.color.lightPinkText0)
                    travelyLogo = R.drawable.union
                }
                1 -> {
                    cityImage = R.drawable.china
                    title1Text = app.m.secondSlideTitle1
                    title2Text = app.m.secondSlideTitle2
                    descriptionText = app.m.secondSlideDescription
                    backgroundColor = getColor(R.color.darkBlueBackground0)
                    textColor = getColor(R.color.darkBlueText0)
                    travelyLogo = R.drawable.union_white
                }
                2 -> {
                    cityImage = R.drawable.tajmahal
                    title1Text = app.m.thirdSlideTitle1
                    title2Text = app.m.thirdSlideTitle2
                    descriptionText = app.m.thirdSlideDescription
                    backgroundColor = getColor(R.color.lightPinkBackground0)
                    textColor = getColor(R.color.lightPinkText0)
                    travelyLogo = R.drawable.union
                }
                3 -> {
                    cityImage = R.drawable.jungle
                    title1Text = app.m.forthSlideTitle1
                    title2Text = app.m.forthSlideTitle2
                    backgroundColor = getColor(R.color.darkBlueBackground0)
                    textColor = getColor(R.color.darkBlueText0)
                    travelyLogo = R.drawable.union_white
                }
            }
        }
    }

    private fun FragmentOnBoardingSlidesBinding.loadImages() {
        if (position != 1) {
            ivTravelyLogo.load(travelyLogo) {
                scale(Scale.FILL)
                allowHardware(false)
            }


            ivCity.load(cityImage) {
                scale(Scale.FILL)
                allowHardware(false)
            }
        }
    }

    private fun FragmentOnBoardingSlidesBinding.setUpTextViews() {
        btnSkip.typeface = app.m.fontMedium
        btnSkip.setTextColor(textColor)
        tvTitle1.typeface = app.m.fontLight
        tvTitle1.setTextColor(textColor)
        tvTitle1.text = title1Text
        tvTitle2.typeface = app.m.fontBold
        tvTitle2.text = title2Text
        tvTitle2.setTextColor(textColor)
        tvDescription.typeface = app.m.fontBold
        tvDescription.setTextColor(textColor)
        tvDescription.text = descriptionText
        tvContinueToApp.typeface = app.m.fontBold
        tvContinueToApp.text = app.m.continueToApp
        tvContinueToApp.isVisible = position == 3
    }

    private fun FragmentOnBoardingSlidesBinding.setUpOnClickListener() {
        btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_to_home_fragment)
        }
        tvContinueToApp.setOnClickListener {
            findNavController().navigate(R.id.action_to_home_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}