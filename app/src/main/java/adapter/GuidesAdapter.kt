package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowGuidesBinding
import ui.base.BaseActivity

class GuidesAdapter(private val activity: BaseActivity) : Adapter<GuidesAdapter.TopGuidesHolder>() {
    inner class TopGuidesHolder(private val binding: RowGuidesBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                app = activity.app
                ivGuides.load("https://i.pcmag.com/imagery/articles/040JHoVNgc1gh2e7sunj82k-1..v1569492349.png") {
                    scale(Scale.FIT)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGuidesHolder {
        return TopGuidesHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_guides, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: TopGuidesHolder, position: Int) {
        holder.bind()
    }
}