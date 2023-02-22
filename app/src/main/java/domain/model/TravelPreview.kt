package domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelPreview(
    val id: Long,
    val name: String,
    val image: String,
    val isFree: Boolean,
    val price: Double,
    val status: String?,
    val views: Long
) : Parcelable {
    companion object {
        const val ADD_ID = 0L
        const val LOADING_ID = -1L
        const val FAILURE_ID = -2L
        fun getAddItem() = TravelPreview(ADD_ID, "", "", true, 0.0, "", 0)
        fun getLoadingItem() = TravelPreview(LOADING_ID, "", "", true, 0.0, "", 0)
        fun getFailureItem() = TravelPreview(FAILURE_ID, "", "", true, 0.0, "", 0)
        fun List<TravelPreview>.cloned() = ArrayList(this.map { it.copy() })
    }
}