package ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpEvent, SignUpAction, SignUpViewModel>(R.layout.fragment_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: SignUpViewModel by viewModels()
        initialize(viewModel)
    }



}