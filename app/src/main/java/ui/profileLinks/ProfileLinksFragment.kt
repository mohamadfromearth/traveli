package ui.profileLinks

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentProfileLinksBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment


@AndroidEntryPoint
class ProfileLinksFragment:BaseFragment<FragmentProfileLinksBinding,ProfileLinksEvent,ProfileLinksAction,ProfileLinksViewModel>(R.layout.fragment_profile_links) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModels:ProfileLinksViewModel by viewModels()
        initialize(viewModels)
    }


}