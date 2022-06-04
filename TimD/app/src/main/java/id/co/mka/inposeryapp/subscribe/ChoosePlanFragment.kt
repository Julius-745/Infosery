package id.co.mka.inposeryapp.subscribe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentChoosePlanBinding
import id.co.mka.inposeryapp.possystem.DashboardTokoActivity

class ChoosePlanFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentChoosePlanBinding

	override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentChoosePlanBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btLanjut.setOnClickListener(this)
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_lanjut) {
			val mInformationPaymentFragment = InformationPaymentFragment()
			val mFragmentManager = parentFragmentManager
			mFragmentManager.beginTransaction().apply {
				replace(
					R.id.frame_container,
					mInformationPaymentFragment,
					InformationPaymentFragment::class.java.simpleName
				)
				addToBackStack(null)
				commit()
			}
			//activity?.let{
			//	val intent = Intent (it, DashboardTokoActivity::class.java)
			//	it.startActivity(intent)
			//}
		}
	}
}
