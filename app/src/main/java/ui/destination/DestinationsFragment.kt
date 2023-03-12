package ui.destination

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentDestinationBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class DestinationsFragment : BaseFragment<FragmentDestinationBinding, DestinationsEvent, DestinationsAction, DestinationsViewModel>(R.layout.fragment_destination) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: DestinationsViewModel by viewModels()
    }
}