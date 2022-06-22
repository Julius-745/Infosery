package id.co.mka.inposeryapp.ui.profile.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryEntity(

	var kode_transaksi: String? = null,
	var plan: Int = 0,
	var biaya: String? = null,
	var status: String? = null
) : Parcelable
