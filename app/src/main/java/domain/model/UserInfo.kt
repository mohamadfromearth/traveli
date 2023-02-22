package domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val id: Long,
    val name: String?,
    val avatar: String?,
    val bio: String?,
    val headerImage: String?,
    val balance: String,
    val country: Country,
    val city: City,
    val hometown: String,
    val contact: Contact,
) : Parcelable
