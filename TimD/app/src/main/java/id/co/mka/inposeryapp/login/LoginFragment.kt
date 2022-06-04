package id.co.mka.inposeryapp.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.MainActivity
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentLoginBinding
import id.co.mka.inposeryapp.register.RegisterActivity
import id.co.mka.inposeryapp.subscribe.SubscribeActivity

class LoginFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentLoginBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.txtForgotpw.setOnClickListener(this)
		binding.btLogin.setOnClickListener(this)
		binding.txtSignup.setOnClickListener(this)

	}
	override fun onClick(v: View) {
		if (v.id == R.id.txt_forgotpw) {
			val mForgotPasswordFragment = ForgotPasswordFragment()
			val mFragmentManager = parentFragmentManager
			mFragmentManager.beginTransaction().apply {
				replace(R.id.frame_container, mForgotPasswordFragment, ForgotPasswordFragment::class.java.simpleName)
				addToBackStack(null)
				commit()
			}
		}

		if (v.id == R.id.bt_login) {
			activity?.let{
				val intent = Intent (it, SubscribeActivity::class.java)
				it.startActivity(intent)
			}
		}

		if (v.id == R.id.txt_signup) {
			activity?.let{
				val intent = Intent (it, RegisterActivity::class.java)
				it.startActivity(intent)
			}
		}

	}
}
