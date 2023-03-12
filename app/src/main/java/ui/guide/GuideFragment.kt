package ui.guide

import adapter.TravelAdapter
import adapter.TravelAdapterMatchParent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentGuideBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.Constant.KEY_GUIDE_PREVIOUS_PAGE_NAME

@AndroidEntryPoint
class GuideFragment : BaseFragment<FragmentGuideBinding, GuideEvent, GuideAction, GuideViewModel>(R.layout.fragment_guide) {
    private lateinit var travelsAdapter: TravelAdapterMatchParent
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GuideViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observerToEvents()
        viewModel.action.onStart(requireArguments().getString(KEY_GUIDE_PREVIOUS_PAGE_NAME, ""))
        binding.ivGuide.load("https://img.a.transfermarkt.technology/portrait/big/3139-1459504284.jpg?lm=1") {
            scale(Scale.FIT)
        }
        setUpRecyclerView()
    }

    private fun init() {
        navController = findNavController()
    }

    private fun observerToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect {
                when (it) {
                    GuideEvent.NavBack -> navController.popBackStack()
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        travelsAdapter = TravelAdapterMatchParent(baseActivity)
        binding.rvTravel.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvTravel.adapter = travelsAdapter
    }
}