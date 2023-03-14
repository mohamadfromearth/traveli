package ui.destinations

import adapter.DestinationAdapter
import android.os.Bundle
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentDestinationsBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.extension.convertDPtoPX
import util.extension.convertPXtoDP
import util.extension.lerp

@AndroidEntryPoint
class DestinationsFragment : BaseFragment<FragmentDestinationsBinding, DestinationsEvent, DestinationsAction, DestinationsViewModel>(R.layout.fragment_destinations) {
    private lateinit var destinations1Adapter: DestinationAdapter
    private lateinit var destinations2Adapter: DestinationAdapter
    private lateinit var destination3Adapter: DestinationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: DestinationsViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerViews()
        animateTitle()
        observeToEvents()
    }

    private fun observeToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect {
                when (it) {
                    DestinationsEvent.NavToDestinations -> findNavController().navigate(R.id.action_destinationsFragment_to_destinationFragment)
                }
            }
        }
    }

    private fun animateTitle() {
        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener() { v, scrolx, scrollY, oldScrolx, oldScroly ->
            val layoutWidthDivededBy2 = convertPXtoDP((binding.root.width / 2f) - binding.tv16SpTravels.width / 2)
            val scrolInDp = convertPXtoDP(scrollY.toFloat())
            val t = if (scrolInDp >= 50) 1f else scrolInDp / 50f
            binding.apply {
                tvTitle.translationY = convertDPtoPX(lerp(0f, -26f, t))
                separator.translationY = convertDPtoPX(lerp(0f, -27.5f, t))
                tvTitle.textSize = lerp(32f, 16f, t)
                tvTitle.translationX = convertDPtoPX(lerp(0f, layoutWidthDivededBy2 - 16, t))
            }
        })
    }

    private fun setUpRecyclerViews() {
        destinations1Adapter = DestinationAdapter(baseActivity, DestinationAdapter.VIEW_TYPE_RECT_ANGLE) {
            viewModel.action.onDestinationItemClick()
        }
        binding.rvDestination.adapter = destinations1Adapter
        destinations2Adapter = DestinationAdapter(baseActivity, DestinationAdapter.VIEW_TYPE_SQUARE) {
            viewModel.action.onDestinationItemClick()
        }
        binding.rvDestination2.adapter = destinations2Adapter
        destination3Adapter = DestinationAdapter(baseActivity, DestinationAdapter.VIEW_TYPE_SQUARE) {
            viewModel.action.onDestinationItemClick()
        }
        binding.rvDestination3.adapter = destination3Adapter
    }
}