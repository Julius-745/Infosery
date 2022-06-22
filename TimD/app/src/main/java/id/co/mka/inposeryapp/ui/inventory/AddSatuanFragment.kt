package id.co.mka.inposeryapp.ui.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentAddSatuanBinding


class AddSatuanFragment : Fragment() , View.OnClickListener{

    private lateinit var binding : FragmentAddSatuanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddSatuanBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSimpanSatuan.setOnClickListener(this)
        binding.btBatalSatuan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.bt_simpan_satuan) {
            val mSatuanFragment = SatuanFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    mSatuanFragment,
                    SatuanFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        } else if (v.id == R.id.bt_batal_satuan) {
            val mSatuanFragment = SatuanFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    mSatuanFragment,
                    SatuanFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}