package id.co.mka.inposeryapp.subscribe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentInformationPaymentBinding
import id.co.mka.inposeryapp.possystem.DashboardTokoActivity

class InformationPaymentFragment : Fragment() , View.OnClickListener {

	private lateinit var binding: FragmentInformationPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentInformationPaymentBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btBuatPesanan.setOnClickListener(this)
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_lanjut) {
			activity?.let{
				val intent = Intent (it, DashboardTokoActivity::class.java)
				it.startActivity(intent)
			}
		}
	}

}
