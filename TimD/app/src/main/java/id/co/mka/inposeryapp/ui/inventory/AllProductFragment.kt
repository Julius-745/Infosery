package id.co.mka.inposeryapp.ui.inventory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentAllProductBinding

class AllProductFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentAllProductBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namaproduk = arguments?.getString(ARG_NAMAPRODUK)
        binding.btAddprodukAllproduk.setOnClickListener(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllProductBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onClick(v: View) {
        if (v.id == R.id.bt_addproduk_allproduk) {
            Log.d("cek", "hit intent")
            activity?.let{
                val intent = Intent (it, AddProductActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    companion object {
        private val ARG_NAMAPRODUK = "namaproduk"
        fun newInstance(namaproduk: String?): AllProductFragment {
            val fragment = AllProductFragment()
            val bundle = Bundle()
            bundle.putString(ARG_NAMAPRODUK, namaproduk)
            fragment.arguments = bundle
            return fragment
        }
    }
}