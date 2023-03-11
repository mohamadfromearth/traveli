package ui.travels

import adapter.TravelAdapter
import adapter.GuidesAdapter
import adapter.UnKnownAdapter
import android.os.Bundle
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentTravelsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ui.base.BaseFragment
import util.Constant.KEY_GUIDES_LIST_TITLE
import util.Constant.KEY_TRAVELS_LIST_TYPE
import util.extension.convertDPtoPX
import util.extension.convertPXtoDP
import util.extension.lerp

@AndroidEntryPoint
class TravelsFragment : BaseFragment<FragmentTravelsBinding, TravelsEvent, TravelsAction, TravelsViewModel>(R.layout.fragment_travels) {
    private lateinit var unKnownAdapter: UnKnownAdapter
    private lateinit var mostPopularAdapter: TravelAdapter
    private lateinit var topGuidesAdapter: GuidesAdapter
    private lateinit var newestTravelsAdapter: TravelAdapter
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TravelsViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        animateTitle()
        observeToEvents()
    }

    private fun init() {
        navController = findNavController()
        setUpRecyclerViews()
    }

    private fun observeToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collectLatest {
                when (it) {
                    is TravelsEvent.NavToTravelsList -> navController.navigate(R.id.action_homeFragment_to_travelsListFragment,
                        Bundle().apply { putSerializable(KEY_TRAVELS_LIST_TYPE, it.travelsListType) }
                    )
                    is TravelsEvent.NavToGuidesList  -> navController.navigate(R.id.action_homeFragment_to_guidesListFragment,
                        Bundle().apply { putString(KEY_GUIDES_LIST_TITLE, it.title) }
                    )
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
            mostPopularAdapter = TravelAdapter(baseActivity)
            rvMostPopular.adapter = mostPopularAdapter
            topGuidesAdapter = GuidesAdapter(baseActivity)
            rvTopGuides.layoutManager = GridLayoutManager(requireContext(), 2).apply { orientation = HORIZONTAL }
            rvTopGuides.adapter = topGuidesAdapter
            newestTravelsAdapter = TravelAdapter(baseActivity)
            rvNewestTravels.adapter = newestTravelsAdapter
        }
    }
}