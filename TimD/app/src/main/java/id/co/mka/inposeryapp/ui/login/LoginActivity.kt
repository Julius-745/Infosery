package id.co.mka.inposeryapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		supportActionBar?.hide()
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

		val mFragmentManager = supportFragmentManager
		val mLoginFragment = LoginFragment()
		val fragment = mFragmentManager.findFragmentByTag(LoginFragment::class.java.simpleName)
		if (fragment !is LoginFragment) {
			Log.d("MyFlexibleFragment", "Fragment Name :" + LoginFragment::class.java.simpleName)
			mFragmentManager
				.beginTransaction()
				.add(R.id.frame_container, mLoginFragment, LoginFragment::class.java.simpleName)
				.commit()
		}
    }
}
