package id.co.mka.inposeryapp.ui.inventory

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentAddProdukBinding

class AddProdukFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentAddProdukBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddProdukBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btSimpan.setOnClickListener(this)
        binding.btCategory.setOnClickListener(this)
        binding.btSatuan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.bt_simpan) {
            activity?.let{
                val intent = Intent (it, InventoryActivity::class.java)
                it.startActivity(intent)
            }
        } else if (v.id == R.id.bt_category) {
            val mCategory = CategoryFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    mCategory,
                    CategoryFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        } else if (v.id == R.id.bt_satuan) {
            val mSatuan = SatuanFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    mSatuan,
                    SatuanFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}