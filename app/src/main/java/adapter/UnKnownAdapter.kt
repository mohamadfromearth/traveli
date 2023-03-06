package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowUnknownBinding
import ui.base.BaseActivity

class UnKnownAdapter(private val activity: BaseActivity) : RecyclerView.Adapter<UnKnownAdapter.UnKnownViewHolder>() {
    inner class UnKnownViewHolder(private val binding: RowUnknownBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.app = activity.app
            binding.ivUnknown.load("https://funsailing.ro/site/wp-content/foto/2015/04/Caraibe-Tobago-Cays4.jpg"){
                scale(Scale.FIT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnKnownViewHolder {
        return UnKnownViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_unknown, parent, false))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: UnKnownViewHolder, position: Int) {
        holder.bind()
    }
}