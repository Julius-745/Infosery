package id.co.mka.inposeryapp.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ItemHistoryPaymentBinding
import id.co.mka.inposeryapp.ui.profile.data.HistoryEntity

class HistoryAdapter(private val listHistory: ArrayList<HistoryEntity>) :
	RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

	inner class HistoryViewHolder(private val binding: ItemHistoryPaymentBinding) :
		RecyclerView.ViewHolder(binding.root) {

		fun bind(userItems: HistoryEntity) {
			with(binding) {
				kodeTransaksi.text = userItems.kode_transaksi
				monthlyPlan.text = R.string.monthly_plan.toString() + "(${userItems.plan})"
				txtHarga.text = userItems.biaya
				txtStatus.text = userItems.status

			}
		}
	}

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HistoryViewHolder {
		val binding = ItemHistoryPaymentBinding.inflate(
			LayoutInflater.from(viewGroup.context),
			viewGroup,
			false
		)
		return HistoryViewHolder(binding)
	}

	override fun onBindViewHolder(historyViewHolder: HistoryViewHolder, position: Int) {
		historyViewHolder.bind(listHistory[position])
	}

	override fun getItemCount(): Int = listHistory.size

}
