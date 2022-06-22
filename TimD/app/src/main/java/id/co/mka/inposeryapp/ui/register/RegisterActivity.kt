package id.co.mka.inposeryapp.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

	private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

		supportActionBar?.hide()
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

		val mFragmentManager = supportFragmentManager
		val mRegisterFragment = RegisterFragment()
		val fragment = mFragmentManager.findFragmentByTag(RegisterFragment::class.java.simpleName)
		if (fragment !is RegisterFragment) {
			Log.d("MyFlexibleFragment", "Fragment Name :" + RegisterFragment::class.java.simpleName)
			mFragmentManager
				.beginTransaction()
				.add(R.id.frame_container, mRegisterFragment, RegisterFragment::class.java.simpleName)
				.commit()
		}
    }
}
