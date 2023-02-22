package domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tag(
    val id: Long,
    val tag: String
) : Parcelable {
    companion object {
        const val ADD_ID = -1L
        fun List<Tag>.cloned() = ArrayList(this)
    }
}
