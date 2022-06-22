package id.co.mka.inposeryapp.ui.subscribe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentSubscribeBinding


class SubscribeFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentSubscribeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentSubscribeBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btCreateToko.setOnClickListener(this)
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_create_toko) {
			val mChoosePlanFragment = ChoosePlanFragment()
			val mFragmentManager = parentFragmentManager
			mFragmentManager.beginTransaction().apply {
				replace(
					R.id.frame_container,
					mChoosePlanFragment,
					ChoosePlanFragment::class.java.simpleName
				)
				addToBackStack(null)
				commit()
			}
		}
	}
}
