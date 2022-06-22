package id.co.mka.inposeryapp.login.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLogin(
    val token: String,
    val statusCode: Int,
    val message: String? = null,
) : Parcelable
