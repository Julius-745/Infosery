package id.co.mka.inposeryapp.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityOnboardingBinding
import id.co.mka.inposeryapp.ui.login.LoginActivity

class OnboardingActivity : AppCompatActivity() {

	private val introSlideAdapter = IntroSlideAdapter(
		listOf(
			IntroSlide(
				"Manage Your <font color=#5171E1>Store Sales</font> and <font color=#5171E1>Revenue</font> Easily",
				"We offer the convenience of your POS System.",
				R.drawable.ob1
			),
			IntroSlide(
				"We Provide you so many <font color=#5171E1>Features</font>",
				"Features such as calculating daily sales, setting roles, inventory management, daily, monthly, weekly transactions in your store.",
				R.drawable.ob2
			),
			IntroSlide(
				"Sign In to Try Our <font color=#5171E1>POS System</font>",
				"Get Free Trial for 15 - Days.",
				R.drawable.ob3
			)
		)
	)

	private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

		supportActionBar?.hide()
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

		binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

		binding.obViewpager.adapter = introSlideAdapter
		setupIndicator()
		setCurrentIndicator(0)
		binding.obViewpager.registerOnPageChangeCallback(object :
			ViewPager2.OnPageChangeCallback() {
			override fun onPageSelected(position: Int) {
				super.onPageSelected(position)
				if (binding.obViewpager.currentItem + 1 < introSlideAdapter.itemCount) {
					binding.btOb.setText(R.string.next)
				} else {
					binding.btOb.setText(R.string.finish)
				}
				setCurrentIndicator(position)
			}
			}
		)

		binding.btOb.setOnClickListener {
			if (binding.obViewpager.currentItem + 1 < introSlideAdapter.itemCount) {
				binding.obViewpager.currentItem += 1
			} else {
				Intent(applicationContext, LoginActivity::class.java).also {
					startActivity(it)
					finish()
				}
			}
		}
    }

	private fun setupIndicator() {
		val indicators = arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
		val layoutParams : LinearLayout.LayoutParams =
			LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
		layoutParams.setMargins(24,0,16,0)
		for (i in indicators.indices) {
			indicators[i] = ImageView(applicationContext)
			indicators[i].apply {
				this?.setImageDrawable(
					ContextCompat.getDrawable(
						applicationContext,
						R.drawable.indicator_inactive
					)
				)
				this?.layoutParams = layoutParams
			}
			binding.indicatorCarosel.addView(indicators[i])
		}
	}

	private fun setCurrentIndicator(index: Int) {
		val childCount = binding.indicatorCarosel.childCount
		for (i in 0 until childCount) {
			val imageView = binding.indicatorCarosel[i] as ImageView
			if (i == index) {
				imageView.setImageDrawable(
					ContextCompat.getDrawable(
						applicationContext,
						R.drawable.indicator_active
					)
				)
			} else{
				imageView.setImageDrawable(
					ContextCompat.getDrawable(
						applicationContext,
						R.drawable.indicator_inactive
					)
				)
			}
		}
	}
}
