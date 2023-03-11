package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowGuidesMatchParentBinding
import ui.base.BaseActivity

class GuidesAdapterMatchParent(private val activity: BaseActivity) : Adapter<GuidesAdapterMatchParent.GuidesHolder>() {
    inner class GuidesHolder(val binding: RowGuidesMatchParentBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                app = activity.app
                ivGuides.load("https://i.pcmag.com/imagery/articles/040JHoVNgc1gh2e7sunj82k-1..v1569492349.png") {
                    scale(Scale.FIT)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuidesHolder {
        return GuidesHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_guides_match_parent, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: GuidesHolder, position: Int) {
        holder.bind()
    }
}