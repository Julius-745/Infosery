package id.co.mka.inposeryapp.ui.possystem

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityDashboardTokoBinding
import id.co.mka.inposeryapp.databinding.HeaderNavBinding

class DashboardTokoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDashboardTokoBinding

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)

		binding = ActivityDashboardTokoBinding.inflate(layoutInflater)

		setContentView(binding.root)

		// show hider recycler
		val headerView: View = binding.navigationDrawer.getHeaderView(0)
		val headerBinding: HeaderNavBinding = HeaderNavBinding.bind(headerView)

		headerBinding.showHideRc.setOnClickListener {
			if (headerBinding.layoutRc.isVisible) {
				headerBinding.layoutRc.visibility = View.GONE
				headerBinding.showHideRc.setImageResource(R.drawable.ic_arrow_down)
			} else {
				headerBinding.layoutRc.visibility = View.VISIBLE
				headerBinding.showHideRc.setImageResource(R.drawable.ic_arrow_up)
			}
		}

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
				R.id.navigation_inventory,
			)
		)
		binding.drawerLayout.addDrawerListener(toggle)
		toggle.syncState()

		setupActionBarWithNavController(navController, appBarConfiguration)
		navView.setupWithNavController(navController)
		binding.navigationDrawer.setupWithNavController(navController)
		//binding.toolbar.setNavigationOnClickListener {
		//	if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
		//		binding.drawerLayout.closeDrawer(GravityCompat.START)
		//	} else {
		//		binding.drawerLayout.openDrawer(GravityCompat.START)
		//	}
		//}

	}
	override fun onBackPressed() {
		if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
			binding.drawerLayout.closeDrawer(GravityCompat.START)
		} else {
			super.onBackPressed()
		}
	}
}
