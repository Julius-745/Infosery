package id.co.mka.inposeryapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentForgotPasswordBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btBack.setOnClickListener(this)
		binding.btReset.setOnClickListener(this)
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_back) {
			val mFragmentManager = parentFragmentManager
			mFragmentManager.popBackStack()
		}

		if (v.id == R.id.bt_reset) {
			val mCheckEmailFragment = CheckEmailFragment()
			val textEmail = binding.edtEmail.text.toString()
			val bundle = Bundle()
			bundle.putString(CheckEmailFragment.ARG_EMAIL, textEmail)
			mCheckEmailFragment.arguments = bundle
			val mFragmentManager = parentFragmentManager
			mFragmentManager.beginTransaction().apply {
				replace(R.id.frame_container, mCheckEmailFragment, CheckEmailFragment::class.java.simpleName)
				addToBackStack(null)
				commit()
			}
		}
	}
}
