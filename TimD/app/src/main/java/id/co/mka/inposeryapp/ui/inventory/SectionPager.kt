package id.co.mka.inposeryapp.ui.inventory

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPager(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    var namaproduk: String? = null
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = AllProductFragment.newInstance(namaproduk)
            1 -> fragment = LowStockFragment.newInstance(namaproduk)
        }
        return fragment as Fragment
    }
}