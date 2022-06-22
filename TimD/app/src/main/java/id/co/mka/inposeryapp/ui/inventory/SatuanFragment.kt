package id.co.mka.inposeryapp.ui.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentSatuanBinding

class SatuanFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentSatuanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSatuanBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btAddSatuan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.bt_add_satuan) {
            val mAddSatuanFragment = AddSatuanFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    mAddSatuanFragment,
                    AddSatuanFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }

}