package ui.profileLinks

import adapter.LinkAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentProfileLinksBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment


@AndroidEntryPoint
class ProfileLinksFragment:BaseFragment<FragmentProfileLinksBinding,ProfileLinksEvent,ProfileLinksAction,ProfileLinksViewModel>(R.layout.fragment_profile_links) {

    private lateinit var linkAdapter:LinkAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModels:ProfileLinksViewModel by viewModels()
        initialize(viewModels)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }


    private fun setUpRecyclerView(){
        linkAdapter = LinkAdapter(baseActivity)
        binding.rvLinks.adapter = linkAdapter
    }


}