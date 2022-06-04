package id.co.mka.inposeryapp.register

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentRegisterSuccessBinding
import id.co.mka.inposeryapp.login.LoginActivity

class RegisterSuccessFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentRegisterSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentRegisterSuccessBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
	}


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btLogin.setOnClickListener(this)

		binding.txtSuccess.text = Html.fromHtml("You have succesfully <font color=#5171E1>Sign Up!</font>")
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_login) {
			activity?.let{
				val intent = Intent (it, LoginActivity::class.java)
				it.startActivity(intent)
			}
		}
	}
}
