package id.alik.tutor_android.presenter.tutordesign.intentlearning.model

import java.io.Serializable

data class PersonIntentSerializable(
    var nama: String,
    var umur: Int,
    var email: String,
    var domisili: String,
    var statusMenikah: Boolean,
) : Serializable
