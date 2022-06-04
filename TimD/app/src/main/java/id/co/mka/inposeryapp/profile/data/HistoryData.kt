package id.co.mka.inposeryapp.profile.data

import id.co.mka.inposeryapp.R

object HistoryData {

	private val kode = arrayOf(
		R.string.txt_transfer.toString(),
		R.string.txt_transfer.toString()
	)

	private val plan = intArrayOf(
		1,
		2
	)

	private val harga = arrayOf(
		R.string.rp_27_000.toString(),
		R.string.rp_54_000.toString()
	)

	private val state = arrayOf(
		R.string.selesai.toString(),
		R.string.harus_dibayar.toString()
	)

	val listData: ArrayList<HistoryEntity>
		get() {
			val list = arrayListOf<HistoryEntity>()
			for (position in kode.indices) {
				val history = HistoryEntity()
				history.kode_transaksi = kode[position]
				history.plan = plan[position]
				history.biaya = harga[position]
				history.status = state[position]
				list.add(history)
			}
			return list
		}
}
