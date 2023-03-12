package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowRectAngleDestinationBinding
import ui.base.BaseActivity

class DestinationAdapter(private val activity: BaseActivity) : RecyclerView.Adapter<DestinationAdapter.RectAngleDestinationHolder>() {
    inner class RectAngleDestinationHolder(private val binding: RowRectAngleDestinationBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                app = activity.app
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RectAngleDestinationHolder {
        return RectAngleDestinationHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_rect_angle_destination,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: RectAngleDestinationHolder, position: Int) {
        holder.bind()
    }
}