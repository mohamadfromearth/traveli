package ui.travelsList

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentTravelsListBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class TravelsListFragment : BaseFragment<FragmentTravelsListBinding, TravelsListEvent, TravelsListAction, TravelsListViewModel>(R.layout.fragment_travels_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TravelsListViewModel by viewModels()
        initialize(viewModel)
    }
}