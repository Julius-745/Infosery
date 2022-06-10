package id.co.mka.inposeryapp.possystem

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityDashboardTokoBinding

class DashboardTokoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDashboardTokoBinding

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)

		binding = ActivityDashboardTokoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// Bottom Navigation
		val navView: BottomNavigationView = binding.navBottomView
		val toggle = ActionBarDrawerToggle(
			this,
			binding.drawerLayout,
			R.string.navigation_drawer_open,
			R.string.navigation_drawer_close
		)

		val navController = findNavController(R.id.nav_host_fragment_activity_dashboard_toko)
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		val appBarConfiguration = AppBarConfiguration(
			setOf(
				R.id.navigation_produk,
				R.id.navigation_bayar,
				R.id.navigation_riwayat,
			)
		)
		binding.drawerLayout.addDrawerListener(toggle)
		toggle.syncState()

		setupActionBarWithNavController(navController, appBarConfiguration)
		navView.setupWithNavController(navController)
		binding.navigationDrawer.setupWithNavController(navController)

	}
}
