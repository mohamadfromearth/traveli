package ui.travels

import adapter.MostPopularAdapter
import adapter.TopGuidesAdapter
import adapter.UnKnownAdapter
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginStart
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentTravelsBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.extension.convertDPtoPX
import util.extension.convertPXtoDP
import util.extension.lerp
import java.io.File.separator

@AndroidEntryPoint
class TravelsFragment : BaseFragment<FragmentTravelsBinding, TravelsEvent, TravelsAction, TravelsViewModel>(R.layout.fragment_travels) {
    private lateinit var unKnownAdapter: UnKnownAdapter
    private lateinit var mostPopularAdapter: MostPopularAdapter
    private lateinit var topGuidesAdapter: TopGuidesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TravelsViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.root.post {
            animateTitle()
        }
        setUpRecyclerViews()
    }

    private fun animateTitle() {
        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener() { v, scrolx, scrollY, oldScrolx, oldScroly ->
            val layoutWidthDivededBy2 = convertPXtoDP((binding.root.width / 2f) - binding.tv16SpTravels.width / 2)
            val scrolInDp = convertPXtoDP(scrollY.toFloat())
            val t = if (scrolInDp >= 34) 1f else scrolInDp / 34f
            binding.apply {
                tvTitle.translationY = convertDPtoPX(lerp(0f, -30f, t))
                separator.translationY = convertDPtoPX(lerp(0f, -30f, t))
                //  Todo UnComment these
                //separator.startX = lerp(convertDPtoPX(16f), 0f, t)
                //separator.stopX = lerp(binding.root.width.toFloat() - convertDPtoPX(16f), binding.root.width.toFloat(), t)
                //separator.requestLayout()
                tvTitle.textSize = lerp(32f, 16f, t)
                tvTitle.translationX = convertDPtoPX(lerp(0f, layoutWidthDivededBy2 - 16, t))
            }
        })
    }

    private fun setUpRecyclerViews() {
        binding.apply {
            unKnownAdapter = UnKnownAdapter(baseActivity)
            rvUnKnown.adapter = unKnownAdapter
            mostPopularAdapter = MostPopularAdapter(baseActivity)
            rvMostPopular.adapter = mostPopularAdapter
            topGuidesAdapter = TopGuidesAdapter(baseActivity)
            rvTopGuides.layoutManager = GridLayoutManager(requireContext(), 2).apply { orientation = HORIZONTAL }
            rvTopGuides.adapter = topGuidesAdapter
        }
    }
}