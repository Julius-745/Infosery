package id.co.mka.inposeryapp.login.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    val message: String? = null,

    val data: Data? = null,
) : Parcelable


@Parcelize
data class Data(
    val token: String? = null,

    val user: User? = null,
) : Parcelable

@Parcelize
data class User(
    val id: Int? = 0,

    val name: String? = null,

    val email: String? = null,

    val password: String? = null,

    val phone: String? = null,

    val verifed: Boolean = false,

    val role: String? = null,

    val token: String? = null,

    val profilePhoto: String? = null,
) : Parcelable