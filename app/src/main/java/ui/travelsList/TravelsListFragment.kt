package ui.travelsList

import adapter.TravelAdapter
import adapter.TravelAdapterMatchParent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentTravelsListBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import util.Constant.KEY_TRAVELS_LIST_TYPE

@AndroidEntryPoint
class TravelsListFragment : BaseFragment<FragmentTravelsListBinding, TravelsListEvent, TravelsListAction, TravelsListViewModel>(R.layout.fragment_travels_list) {
    private lateinit var travelAdapter: TravelAdapterMatchParent;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TravelsListViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.action.onStart(getTravelListType()!!)
        setUpRecyclerView()
        observerToEvents()
    }

    private fun observerToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect {
                when (it) {
                    TravelsListEvent.NavBack -> findNavController().popBackStack()
                }
            }
        }
    }

    private fun getTravelListType(): TravelsListType? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(KEY_TRAVELS_LIST_TYPE, TravelsListType::class.java)
        } else {
            arguments?.getSerializable(KEY_TRAVELS_LIST_TYPE) as TravelsListType
        }
    }

    private fun setUpRecyclerView() {
        travelAdapter = TravelAdapterMatchParent(baseActivity)
        binding.rvTravels.adapter = travelAdapter
        binding.rvTravels.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}

