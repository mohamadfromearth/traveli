package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowTravelsBinding
import ui.base.BaseActivity

class TravelAdapter(private val activity: BaseActivity) : RecyclerView.Adapter<TravelAdapter.MostPopularHolder>() {
    inner class MostPopularHolder(private val binding: RowTravelsBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                app = activity.app
                ivMostPopular.load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Towers_in_Tehran_City_at_night.jpg/800px-Towers_in_Tehran_City_at_night.jpg?20150430213944") {
                    scale(Scale.FILL)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularHolder {
        return MostPopularHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_travels, parent, false))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MostPopularHolder, position: Int) {
        holder.bind()
    }
}