package ui.guidesList

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
import ui.base.BaseFragment
import util.Constant.KEY_GUIDES_LIST_TITLE
import util.Constant.KEY_GUIDE_PREVIOUS_PAGE_NAME

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
                    GuidesListEvent.NavBack       -> navController.popBackStack()
                    is GuidesListEvent.NavToGuide -> {
                        navController.navigate(R.id.action_guidesListFragment_to_guideFragment, Bundle().apply {
                            putString(KEY_GUIDE_PREVIOUS_PAGE_NAME, it.pageName)
                        })
                    }
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        guidesAdapter = GuidesAdapterMatchParent(baseActivity) { position ->
            viewModel.action.onItemClick(position)
        }
        binding.rvGuides.adapter = guidesAdapter
    }
}