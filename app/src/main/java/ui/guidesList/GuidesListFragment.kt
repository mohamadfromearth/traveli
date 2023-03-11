package ui.guidesList

import adapter.GuidesAdapter
import adapter.GuidesAdapterMatchParent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentGuidesListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ui.base.BaseFragment
import util.Constant.KEY_GUIDES_LIST_TITLE

@AndroidEntryPoint
class GuidesListFragment : BaseFragment<FragmentGuidesListBinding, GuidesListEvent, GuidesListAction, GuidesListViewModel>(R.layout.fragment_guides_list) {
    private lateinit var guidesAdapter: GuidesAdapterMatchParent
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GuidesListViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.action.onStart(requireArguments().getString(KEY_GUIDES_LIST_TITLE, ""))
        init()
        observeToEvents()
        setUpRecyclerView()
    }

    private fun init() {
        navController = findNavController()
    }

    private fun observeToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect {
                when (it) {
                    GuidesListEvent.NavBack -> navController.popBackStack()
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        guidesAdapter = GuidesAdapterMatchParent(baseActivity)
        binding.rvGuides.adapter = guidesAdapter
    }
}