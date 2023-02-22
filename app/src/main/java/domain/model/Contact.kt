package domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    var phone: ContactItem,
    var email: ContactItem,
    var twitter: ContactItem,
    var instagram: ContactItem,
    var website: ContactItem,
) : Parcelable
