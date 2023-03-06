package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowTopGuidesBinding
import ui.base.BaseActivity

class TopGuidesAdapter(private val activity: BaseActivity) : Adapter<TopGuidesAdapter.TopGuidesHolder>() {
    inner class TopGuidesHolder(private val binding: RowTopGuidesBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                app = activity.app
                ivTopGuides.load("https://i.pcmag.com/imagery/articles/040JHoVNgc1gh2e7sunj82k-1..v1569492349.png") {
                    scale(Scale.FIT)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGuidesHolder {
        return TopGuidesHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_top_guides, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: TopGuidesHolder, position: Int) {
        holder.bind()
    }
}