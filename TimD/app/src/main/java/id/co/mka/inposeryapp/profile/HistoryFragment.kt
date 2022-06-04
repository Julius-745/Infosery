package id.co.mka.inposeryapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentHistoryBinding
import id.co.mka.inposeryapp.profile.data.HistoryData
import id.co.mka.inposeryapp.profile.data.HistoryEntity

class HistoryFragment : Fragment() {

	private lateinit var binding: FragmentHistoryBinding
	private lateinit var adapter: HistoryAdapter
	private var list_history : ArrayList<HistoryEntity> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
		return binding.root
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		list_history.addAll(HistoryData.listData)
		binding.rvPayment.layoutManager = LinearLayoutManager(activity)
		binding.rvPayment.adapter = adapter
	}

}
