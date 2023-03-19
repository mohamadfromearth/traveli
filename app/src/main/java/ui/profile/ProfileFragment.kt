package ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment
import ui.travels.TravelsEvent

@AndroidEntryPoint
class ProfileFragment() : BaseFragment<FragmentProfileBinding, ProfileEvent, ProfileAction, ProfileViewModel>(R.layout.fragment_profile) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ProfileViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivProfile.load("https://static.wikia.nocookie.net/moviedatabase/images/8/8c/Tony_Stark.jpg/revision/latest?cb=20150430161420") {
            scale(Scale.FIT)
        }
        observeToEvents()
    }

    private fun observeToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect{
                when(it){
                    ProfileEvent.NavToEditProfile -> Unit
                }
            }
        }
    }
}