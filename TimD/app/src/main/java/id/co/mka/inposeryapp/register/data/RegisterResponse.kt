package id.co.mka.inposeryapp.register.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RegisterResponse (
    val message: String? = null,
    val data: Data? = null,
): Parcelable

@Parcelize
data class Data (
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
    val phone: String? = null,
    val verifed: Boolean? = false,
    val role: String? = null,
    val profilePhoto: String? = null,
    val token: String? = null,
    val id: Int? = 0,
): Parcelable