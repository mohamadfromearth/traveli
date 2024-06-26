package ui.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpEvent, SignUpAction, SignUpViewModel>(R.layout.fragment_sign_up) {


    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: SignUpViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setUpViews()
        observeToEvents()
    }


    private fun setUpViews() {
        binding.btnContinue.setOnClickListener {
            viewModel.action.onContinueClick("")
        }
    }

    private fun observeToEvents(){
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect{
                when(it){
                    is SignUpEvent.NavToEmailSent -> navController.navigate(R.id.action_signUpFragment_to_emailSentFragment)
                    is SignUpEvent.NavToGuideLines -> navController.navigate(R.id.action_signUpFragment_to_guideLinesFragment)
                }
            }
        }
    }
}