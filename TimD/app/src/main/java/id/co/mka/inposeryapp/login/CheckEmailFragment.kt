package id.co.mka.inposeryapp.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentCheckEmailBinding

class CheckEmailFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentCheckEmailBinding

	companion object {
		const val ARG_EMAIL = "arg_email"
	}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentCheckEmailBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btBack.setOnClickListener(this)
		binding.btSendEmail.setOnClickListener(this)

		if (arguments != null) {
			val textEmail = arguments?.getString(ARG_EMAIL)
			binding.txtEmail.text = textEmail
		}
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_back) {
			val mFragmentManager = parentFragmentManager
			mFragmentManager.popBackStack()
		}

		if (v.id == R.id.bt_send_email) {
			val mResetPasswordFragment = ResetPasswordFragment()
			val mFragmentManager = parentFragmentManager
			mFragmentManager.beginTransaction().apply {
				replace(R.id.frame_container, mResetPasswordFragment, ResetPasswordFragment::class.java.simpleName)
				addToBackStack(null)
				commit()
			}
		}
	}

}
