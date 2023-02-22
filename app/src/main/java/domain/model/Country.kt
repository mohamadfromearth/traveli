package domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val id: Long,
    val name: String,
    val code: String?,
    val image: String?
) : Parcelable {
    companion object {
        const val LOADING_ID = -1L
        const val FAILURE_ID = -2L
        fun getLoadingItem() = Country(LOADING_ID, "", "", "")
        fun getFailureItem() = Country(FAILURE_ID, "", "", "")

        fun List<Country>.cloned() = ArrayList(this.map { it.copy() })
    }
}
