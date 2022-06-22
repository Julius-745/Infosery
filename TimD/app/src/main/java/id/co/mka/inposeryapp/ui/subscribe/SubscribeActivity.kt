package id.co.mka.inposeryapp.ui.subscribe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivitySubscribeBinding

class SubscribeActivity : AppCompatActivity() {

	private lateinit var binding: ActivitySubscribeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = ActivitySubscribeBinding.inflate(layoutInflater)
        setContentView(binding.root)

		supportActionBar?.title = "Berlangganan"

		val mFragmentManager = supportFragmentManager
		val mCreateTokoFragment = SubscribeFragment()
		val fragment = mFragmentManager.findFragmentByTag(SubscribeFragment::class.java.simpleName)
		if (fragment !is SubscribeFragment) {
			Log.d("MyFlexibleFragment", "Fragment Name :" + SubscribeFragment::class.java.simpleName)
			mFragmentManager
				.beginTransaction()
				.add(R.id.frame_container, mCreateTokoFragment, SubscribeFragment::class.java.simpleName)
				.commit()
		}
    }
}
