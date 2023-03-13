package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.RowRectAngleDestinationBinding
import com.xodus.traveli.databinding.RowSquareDestinationBinding
import ui.base.BaseActivity

class DestinationAdapter(private val activity: BaseActivity, private val viewType: Int) : RecyclerView.Adapter<ViewHolder>() {
    companion object {
        const val VIEW_TYPE_RECT_ANGLE = 0
        const val VIEW_TYPE_SQUARE = 1
    }

    inner class RectAngleDestinationHolder(private val binding: RowRectAngleDestinationBinding) : ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                app = activity.app
                ivDestination.load("https://travellersworldwide.com/wp-content/uploads/2022/06/shutterstock_552100717.png.webp") {
                    scale(Scale.FIT)
                }
            }
        }
    }

    inner class SquareDestinationHolder(private val binding: RowSquareDestinationBinding) : ViewHolder(binding.root){
        fun bind(){
            binding.apply {
                app = activity.app
                ivDestination.load("https://travellersworldwide.com/wp-content/uploads/2022/06/shutterstock_552100717.png.webp") {
                    scale(Scale.FIT)
                }
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (this.viewType) {
            VIEW_TYPE_RECT_ANGLE -> return RectAngleDestinationHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.row_rect_angle_destination,
                    parent,
                    false
                )
            )
            VIEW_TYPE_SQUARE     -> SquareDestinationHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.row_square_destination,
                    parent,
                    false
                )
            )
            else                 -> SquareDestinationHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.row_square_destination,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is SquareDestinationHolder    -> holder.bind()
            is RectAngleDestinationHolder -> holder.bind()
        }
    }
}