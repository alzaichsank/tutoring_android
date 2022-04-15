package id.alik.tutor_android.tutordesign.intentlearning.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonIntentParcelable(
    var nama: String,
    var umur: Int,
    var email: String,
    var domisili: String,
    var statusMenikah: Boolean,
) : Parcelable
