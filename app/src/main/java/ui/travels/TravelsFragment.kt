package ui.travels

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentTravelsBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.extension.convertDPtoPX
import util.extension.convertPXtoDP
import util.extension.lerp

@AndroidEntryPoint
class TravelsFragment : BaseFragment<FragmentTravelsBinding, TravelsEvent, TravelsAction, TravelsViewModel>(R.layout.fragment_travels) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TravelsViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.root.post { animateTitle() }
    }

    private fun animateTitle() {
        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener() { v, scrolx, scrollY, oldScrolx, oldScroly ->
            val layoutWidthDivededBy2 = convertPXtoDP((binding.root.width / 2f) - binding.tv16SpTravels.width / 2)
            val scrolInDp = convertPXtoDP(scrollY.toFloat())
            val t = if (scrolInDp >= 34) 1f else scrolInDp / 34f
            binding.apply {
                tvTitle.translationY = convertDPtoPX(lerp(0f, -30f, t))
                separator.translationY = convertDPtoPX(lerp(0f, -29f, t))
                tvTitle.textSize = lerp(32f, 16f, t)
                tvTitle.translationX = convertDPtoPX(lerp(0f, layoutWidthDivededBy2 - 16, t))
            }
        })
    }


}