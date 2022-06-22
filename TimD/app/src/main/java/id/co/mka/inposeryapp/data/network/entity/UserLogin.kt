package id.co.mka.inposeryapp.data.network.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLogin(
    val token: String,
    val statusCode: Int,
    val message: String? = null,
) : Parcelable
