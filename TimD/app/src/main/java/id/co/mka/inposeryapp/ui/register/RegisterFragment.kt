package id.co.mka.inposeryapp.ui.register

import android.content.ContentValues.TAG
import android.content.Intent
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
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.data.network.retrofit.Retrofit
import id.co.mka.inposeryapp.databinding.FragmentRegisterBinding
import id.co.mka.inposeryapp.ui.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentRegisterBinding
	private val viewModel: RegisterViewModel by viewModel()
	private var pl = 0
	private var validateName = false
	private var validateEmail = false
	private var validatePw = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container, false)
        val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.pwStrength1.visibility = View.GONE
		binding.pwStrength2.visibility = View.GONE
		binding.pwStrength3.visibility = View.GONE
		binding.txtStrength.visibility = View.GONE

		binding.txtLogin.setOnClickListener(this)
		binding.btRegister.setOnClickListener(this)

		binding.edtName.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(p0: Editable?) {
				Log.d(TAG, "onTextChanged: after")
			}

			override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				Log.d(TAG, "onTextChanged: after")
			}

			override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				if (TextUtils.isEmpty(binding.edtName.text.toString()) && p1 > 3)
				{
					Log.d(TAG, "name: true")
					validateName = false
					binding.edtName.setCompoundDrawablesWithIntrinsicBounds(0,0, 0,0)
				} else {
					Log.d(TAG, "name: false")
					validateName = true
					binding.edtName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_correct,0)
				}
			}
		})

		binding.edtEmail.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(p0: Editable?) {
				Log.d(TAG, "onTextChanged: after")
			}

			override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				Log.d(TAG, "onTextChanged: after")
			}

			override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				if (TextUtils.isEmpty(binding.edtEmail.text.toString()) && p1 > 3)
				{
					Log.d(TAG, "name: true")
					validateEmail = false
					binding.edtEmail.setCompoundDrawablesWithIntrinsicBounds(0,0, 0,0)
				} else {
					Log.d(TAG, "name: false")
					validateEmail = true
					binding.edtEmail.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_correct,0)
				}
			}
		})

		binding.edtPw.addTextChangedListener(object : TextWatcher  {
			override fun afterTextChanged(p0: Editable?) {
				Log.d(TAG, "onTextChanged: after")

			}

			override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				Log.d(TAG, "onTextChanged: before" +p1.toString()+ " - " +p2.toString()+ " - "+p3.toString())

			}
			override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				val password = binding.edtPw.text.toString()
				val i = validateEdt(password)
				if (p2 == 1) {
					pl -= 1
				}
				if (p3 == 1) {
					pl += 1
				}

				if (TextUtils.isEmpty(password))
				{
					validatePw = false
					binding.pwStrength1.visibility = View.GONE
					binding.pwStrength2.visibility = View.GONE
					binding.pwStrength3.visibility = View.GONE
					binding.txtStrength.visibility = View.GONE
				} else {
					binding.pwStrength1.visibility = View.VISIBLE
					binding.pwStrength2.visibility = View.VISIBLE
					binding.pwStrength3.visibility = View.VISIBLE
					binding.txtStrength.visibility = View.VISIBLE
					if (pl < 8 || i == 1) {
						validatePw = false
						binding.pwStrength1.setImageResource(R.drawable.strength_low)
						binding.pwStrength2.setImageResource(R.drawable.strength_default)
						binding.pwStrength3.setImageResource(R.drawable.strength_default)
						binding.txtStrength.setText(R.string.weak_password)
						binding.txtStrength.setTextColor(ContextCompat.getColor(context!!.applicationContext, R.color.low))
					} else if (pl >= 8 && i == 2) {
						validatePw = true
						binding.pwStrength1.setImageResource(R.drawable.strength_fear)
						binding.pwStrength2.setImageResource(R.drawable.strength_fear)
						binding.pwStrength3.setImageResource(R.drawable.strength_default)
						binding.txtStrength.setText(R.string.fear_password)
						binding.txtStrength.setTextColor(ContextCompat.getColor(context!!.applicationContext, R.color.fear))
					} else if (pl >= 8 && i == 3) {
						validatePw = true
						binding.pwStrength1.setImageResource(R.drawable.strength_strong)
						binding.pwStrength2.setImageResource(R.drawable.strength_strong)
						binding.pwStrength3.setImageResource(R.drawable.strength_strong)
						binding.txtStrength.setText(R.string.strong_password)
						binding.txtStrength.setTextColor(ContextCompat.getColor(context!!.applicationContext, R.color.strong))
					}
				}
			}
		})
	}

	override fun onClick(v: View) {
		if (v.id == R.id.txt_login) {
			activity?.let{
				val intent = Intent (it, LoginActivity::class.java)
				it.startActivity(intent)
			}
		}

		if (v.id == R.id.bt_register) {
			register()
		}
	}

	private fun validateEdt(text: String): Int {
		var count = 0
		if (text.matches(Regex("(.*)[a-z](.*)"))) {
			count+=1
		}
		if (text.matches(Regex("(.*)[A-Z](.*)"))) {
			count+=1
		}
		if (text.matches(Regex("(.*)[0-9](.*)"))) {
			count+=1
		}
		return count
	}

	private fun register() {
		if(!validateName) {
			Toast.makeText(
				activity,
				"Harap Isi Nama Dengan Benar",
				Toast.LENGTH_SHORT
			).show()
		} else if (!validateEmail) {
			Toast.makeText(
				activity,
				"Harap Isi Email Dengan Benar",
				Toast.LENGTH_SHORT
			).show()
		} else if (!validatePw) {
			val password = binding.edtPw.text.toString()
			if(TextUtils.isEmpty(password)) {
				Toast.makeText(
					activity,
					"Password Tidak Boleh Kosong",
					Toast.LENGTH_SHORT
				).show()
			} else {
				Toast.makeText(
					activity,
					"Password Terlalu Lemah",
					Toast.LENGTH_SHORT
				).show()
			}
		} else {
			showLoading(true)
			viewModel.registerUser(
				binding.edtName.toString(),
				binding.edtEmail.toString(),
				"",
				binding.edtPw.toString(),
			).observe(this) {
				showLoading(false)
				if (it.statusCode > 200) {
					Toast.makeText(
						activity,
						"Failed to register , ${it.message}",
						Toast.LENGTH_SHORT
					).show()
				} else {
					Toast.makeText(
						activity,
						"Selamat Datang : ${it.name}",
						Toast.LENGTH_SHORT
					).show()
					val mRegisterSuccessFragment = RegisterSuccessFragment()
					val mFragmentManager = parentFragmentManager
					mFragmentManager.beginTransaction().apply {
						replace(R.id.frame_container, mRegisterSuccessFragment, RegisterSuccessFragment::class.java.simpleName)
						addToBackStack(null)
						commit()
					}
				}
			}
		}
	}

	private fun showLoading(state: Boolean) {
		if (state) {
			binding.btRegister.text = "Loading ...."
			binding.btRegister.isEnabled = false
		} else {
			binding.btRegister.text = "Create Account"
			binding.btRegister.isEnabled = true
		}
	}
}
