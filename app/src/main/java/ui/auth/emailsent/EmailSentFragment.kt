package ui.auth.emailsent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentEmailSentBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class EmailSentFragment :
    BaseFragment<FragmentEmailSentBinding, EmailSentEvent, EmailSentAction, EmailSentViewModel>(R.layout.fragment_email_sent) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: EmailSentViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}