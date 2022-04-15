package id.alik.tutor_android.tutordesign.intentlearning.model

import java.io.Serializable

class PersonIntentSerializable(
    var nama: String,
    var umur: Int,
    var email: String,
    var domisili: String,
    var statusMenikah: Boolean,
) : Serializable
