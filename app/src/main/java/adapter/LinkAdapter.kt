package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowProfileLinkBinding
import ui.base.BaseActivity

class LinkAdapter(private val activity:BaseActivity) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LinkViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.fragment_profile_links,
                parent,
                false
            )
        )
    }

    inner class LinkViewHolder(private val binding: RowProfileLinkBinding) :
        ViewHolder(binding.root)


    override fun getItemCount(): Int {
        return 1;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}