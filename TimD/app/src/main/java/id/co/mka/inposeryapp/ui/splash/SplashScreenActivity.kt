package id.co.mka.inposeryapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import id.co.mka.inposeryapp.databinding.ActivitySplashScreenBinding
import id.co.mka.inposeryapp.ui.onboarding.OnboardingActivity

class SplashScreenActivity : AppCompatActivity() {

	private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		supportActionBar?.hide()
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
		binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

		binding.ssLogo.alpha = 0f
		binding.ssLogo.animate().setDuration(3000).alpha(1f).withEndAction {
			val i = Intent(this, OnboardingActivity::class.java)
			startActivity(i)
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
			finish()
		}
    }
}
