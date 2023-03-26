package ui.auth.guideLines

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentGuidelinesBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class GuideLinesFragment : BaseFragment<FragmentGuidelinesBinding, GuideLinesEvent, GuideLinesAction, GuideLinesViewModel>(R.layout.fragment_guidelines) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GuideLinesViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}