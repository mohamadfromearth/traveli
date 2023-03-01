package ui.travels

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentTravelsBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.extension.convertPXtoDP
import util.extension.log

@AndroidEntryPoint
class TravelsFragment : BaseFragment<FragmentTravelsBinding, TravelsEvent, TravelsAction, TravelsViewModel>(R.layout.fragment_travels) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TravelsViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var separatorInitialMargin = 0
        val travelsLp = binding.tvTitle.layoutParams as ConstraintLayout.LayoutParams
        val layoutWidth = convertPXtoDP(binding.parent.layoutParams.width.toFloat())
        var isFirstListenerCalled = true
        var previousScrollY = 0
        binding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (isFirstListenerCalled) {
                previousScrollY = scrollY
                isFirstListenerCalled = false
            }

            if (scrollY > previousScrollY){

            }
        }
    }
}