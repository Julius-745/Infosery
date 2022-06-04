package id.co.mka.inposeryapp.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentResetCompleteBinding

class ResetCompleteFragment : Fragment(), View.OnClickListener  {

	private lateinit var binding: FragmentResetCompleteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentResetCompleteBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btBack.setOnClickListener(this)
		binding.btLogin.setOnClickListener(this)
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_back) {
			val mFragmentManager = parentFragmentManager
			mFragmentManager.popBackStack()
		}

		if (v.id == R.id.bt_login) {
			parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}
	}

}
