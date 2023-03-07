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
                ivMostPopular.load("https://tourscanner.com/blog/wp-content/uploads/2020/12/Burj-Khalifa-Dubai.jpg") {
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