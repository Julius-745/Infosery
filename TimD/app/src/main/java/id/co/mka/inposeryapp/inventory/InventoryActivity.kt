package id.co.mka.inposeryapp.inventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityInventoryBinding

class InventoryActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAMA = "extra_nama"
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
    private lateinit var binding: ActivityInventoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInventoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionPagerAdapter = SectionPager(this)
        binding.viewPager.adapter = sectionPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab , position ->
        tab.text = resources.getString(TAB_TITLES[position])}.attach()

        supportActionBar?.title = "Inventory"
    }
}