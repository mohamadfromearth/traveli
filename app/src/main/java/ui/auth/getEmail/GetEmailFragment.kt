package ui.auth.getEmail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentGetEmailBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class GetEmailFragment : BaseFragment<FragmentGetEmailBinding, GetEmailEvent, GetEmailAction, GetEmailViewModel>(R.layout.fragment_get_email) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GetEmailViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeToEvents()
    }

    private fun setUpViews() {
        binding.btnContinue.setOnClickListener {
            viewModel.action.onContinueClick(binding.tvEmail.text.toString())
        }
    }

    private fun observeToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect {
                when (it) {
                    is GetEmailEvent.NavToGetPassword -> Unit
                }
            }
        }
    }
}