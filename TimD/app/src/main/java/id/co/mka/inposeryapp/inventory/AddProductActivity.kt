package id.co.mka.inposeryapp.inventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.ActivityAddProdukBinding
import id.co.mka.inposeryapp.databinding.ActivitySubscribeBinding
import id.co.mka.inposeryapp.subscribe.SubscribeFragment

class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProdukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Tambah Produk"

        val mFragmentManager = supportFragmentManager
        val mAddProdukFragment = AddProdukFragment()
        val fragment = mFragmentManager.findFragmentByTag(AddProdukFragment::class.java.simpleName)
        if (fragment !is AddProdukFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + AddProdukFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mAddProdukFragment, AddProdukFragment::class.java.simpleName)
                .commit()
        }
    }
}