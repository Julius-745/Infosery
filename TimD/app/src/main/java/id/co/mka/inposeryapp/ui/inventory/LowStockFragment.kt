package id.co.mka.inposeryapp.ui.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.mka.inposeryapp.databinding.FragmentLowStockBinding

class LowStockFragment : Fragment() {
    private lateinit var binding: FragmentLowStockBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namaproduk = arguments?.getString(ARG_NAMAPRODUK)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLowStockBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    companion object {
        private val ARG_NAMAPRODUK = "namaproduk"
        fun newInstance(namaproduk: String?): LowStockFragment {
            val fragment = LowStockFragment()
            val bundle = Bundle()
            bundle.putString(ARG_NAMAPRODUK, namaproduk)
            fragment.arguments = bundle
            return fragment
        }
    }
}