package ui.destination

import adapter.GuidesAdapter
import adapter.TravelAdapter
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentDestinationBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.extension.convertDPtoPX
import util.extension.convertPXtoDP
import util.extension.convertSPtoPX
import util.extension.lerp
import java.io.File.separator

@AndroidEntryPoint
class DestinationFragment : BaseFragment<FragmentDestinationBinding, DestinationEvent, DestinationAction, DestinationViewModel>(R.layout.fragment_destination) {
    private lateinit var travelAdapter: TravelAdapter
    private lateinit var guideAdapter: GuidesAdapter
    private lateinit var travelAdapter2: TravelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: DestinationViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerViews()
        scrollAnimation()
    }

    private fun scrollAnimation() {
        binding.apply {
            root.post {
                val titleInitialHeight = convertPXtoDP(tvTitle34sp.height.toFloat())
                val tvDescriptionLp = tvDescription.layoutParams as ConstraintLayout.LayoutParams
                tvDescriptionLp.topMargin = (convertDPtoPX(34f) + convertDPtoPX(24f) + convertDPtoPX(titleInitialHeight)).toInt()
                tvDescription.layoutParams = tvDescriptionLp
            }

            ns.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener() { v, scrolx, scrollY, oldScrolx, oldScroly ->
                val title16SpWidth = convertPXtoDP(tvTitle16sp.width.toFloat())
                val screenHalfInDp = convertPXtoDP(root.width / 2f)
                val scrollInDp = convertPXtoDP(scrollY.toFloat())
                val titleT = if (scrollInDp >= 50f) 1f else scrollInDp / 50f
                val t = if (scrollInDp >= 100f) 1f else scrollInDp / 100f
                val covert = if (scrollInDp >= 300f) 1f else scrollInDp / 300f
                tvTitle.translationX = convertDPtoPX(lerp(0f, screenHalfInDp - 20f - title16SpWidth / 2f, titleT))
                tvTitle.translationY = convertDPtoPX(lerp(0f, -58f, titleT))
                tvTitle.textSize = lerp(32f, 16f, titleT)
                tvDescription.alpha = lerp(1f, 0f, t)
                ivCover.translationY = -scrollInDp
                ivCover.alpha = lerp(1f, 0f, covert)
                separator1.alpha = lerp(0f, 1f, titleT)
                separator2.alpha = lerp(1f, 0f, titleT)
            })
        }
    }

    private fun setUpRecyclerViews() {
        travelAdapter = TravelAdapter(baseActivity)
        guideAdapter = GuidesAdapter(baseActivity)
        binding.rvTravels.adapter = travelAdapter
        binding.rvGuides.layoutManager = GridLayoutManager(requireContext(), 2).apply { orientation = RecyclerView.HORIZONTAL }
        binding.rvGuides.adapter = guideAdapter
        travelAdapter2 = TravelAdapter(baseActivity)
        binding.rvTravels2.adapter = travelAdapter2
    }
}