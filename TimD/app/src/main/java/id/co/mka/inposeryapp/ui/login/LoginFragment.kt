package id.co.mka.inposeryapp.ui.login

import android.content.ContentValues
import android.content.Intent
import android.content.Intent.EXTRA_USER
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentLoginBinding
import id.co.mka.inposeryapp.ui.register.RegisterActivity
import id.co.mka.inposeryapp.ui.subscribe.SubscribeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentLoginBinding
	private val viewModel: LoginViewModel by viewModel()
	private var validateEmail = false
	private var validatePassword = false

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

		binding.edtEmail.addTextChangedListener(object : TextWatcher {
			override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				Log.d(ContentValues.TAG, "onTextChanged: before")
			}

			override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				cekEmail()
			}

			override fun afterTextChanged(p0: Editable?) {
				Log.d(ContentValues.TAG, "onTextChanged: after")
			}

		})

		binding.edtPassword.addTextChangedListener(object : TextWatcher {
			override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				Log.d(ContentValues.TAG, "onTextChanged: before")
			}

			override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				cekPass()
			}

			override fun afterTextChanged(p0: Editable?) {
				Log.d(ContentValues.TAG, "onTextChanged: after")
			}

		})

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
			if(!validateEmail){
				Toast.makeText(
					activity,
					"Email Tidak Boleh Kosong",
					Toast.LENGTH_SHORT
				).show()
			} else if(!validatePassword){
				Toast.makeText(
					activity,
					"Password Tidak Boleh Kosong",
					Toast.LENGTH_SHORT
				).show()
			} else {
				doLogin()
			}
		}

		if (v.id == R.id.txt_signup) {
			activity?.let{
				val intent = Intent (it, RegisterActivity::class.java)
				it.startActivity(intent)
			}
		}

	}

	private fun doLogin() {
		showLoading(true)
		viewModel.loginUser(
			binding.edtEmail.text.toString(),
			binding.edtPassword.text.toString()
		).observe(this) { result ->
			showLoading(false)
			if(result.statusCode > 200) {
				Toast.makeText(
					activity,
					"Login gagal, ${result.message}",
					Toast.LENGTH_SHORT
				).show()
			} else {
				Toast.makeText(
					activity,
					"Hello ${result.token}",
					Toast.LENGTH_SHORT
				).show()
				activity?.let{
					val intent = Intent (it, SubscribeActivity::class.java).apply { putExtra(EXTRA_USER, result) }
					it.startActivity(intent)
				}
			}
		}
	}

	private fun showLoading(state: Boolean) {
		if (state) {
			binding.btLogin.text = "Loading ...."
			binding.btLogin.isEnabled = false
		} else {
			binding.btLogin.text = "Login"
			binding.btLogin.isEnabled = true
		}
	}

	private fun cekEmail() {
		validateEmail = !TextUtils.isEmpty(binding.edtEmail.text.toString())
	}

	private fun cekPass() {
		validatePassword = !TextUtils.isEmpty(binding.edtPassword.text.toString())
	}
}
