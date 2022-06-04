package id.co.mka.inposeryapp.login

import android.content.ContentValues
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import id.co.mka.inposeryapp.R
import id.co.mka.inposeryapp.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentResetPasswordBinding
	private var pl = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
		binding = FragmentResetPasswordBinding.inflate(inflater,container, false)
		val view = binding.root
		return view
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btBack.setOnClickListener(this)
		binding.btReset.setOnClickListener(this)

		binding.pwStrength1.visibility = View.GONE
		binding.pwStrength2.visibility = View.GONE
		binding.pwStrength3.visibility = View.GONE
		binding.txtStrength.visibility = View.GONE

		binding.edtNewpw.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(p0: Editable?) {
				Log.d(ContentValues.TAG, "onTextChanged: after")

			}

			override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				Log.d(ContentValues.TAG, "onTextChanged: before" +p1.toString()+ " - " +p2.toString()+ " - "+p3.toString())

			}
			override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
				val password = binding.edtNewpw.text.toString()
				val i = validateEdt(password)
				if (p2 == 1) {
					pl -= 1
				}
				if (p3 == 1) {
					pl += 1
				}

				if (TextUtils.isEmpty(password))
				{
					binding.pwStrength1.visibility = View.GONE
					binding.pwStrength2.visibility = View.GONE
					binding.pwStrength3.visibility = View.GONE
					binding.txtStrength.visibility = View.GONE
				} else {
					binding.pwStrength1.visibility = View.VISIBLE
					binding.pwStrength2.visibility = View.VISIBLE
					binding.pwStrength3.visibility = View.VISIBLE
					binding.txtStrength.visibility = View.VISIBLE
					if (pl < 8 || i == 1) {
						binding.pwStrength1.setImageResource(R.drawable.strength_low)
						binding.pwStrength2.setImageResource(R.drawable.strength_default)
						binding.pwStrength3.setImageResource(R.drawable.strength_default)
						binding.txtStrength.setText(R.string.weak_password)
						binding.txtStrength.setTextColor(ContextCompat.getColor(context!!.applicationContext, R.color.low))
					} else if (pl >= 8 && i == 2) {
						binding.pwStrength1.setImageResource(R.drawable.strength_fear)
						binding.pwStrength2.setImageResource(R.drawable.strength_fear)
						binding.pwStrength3.setImageResource(R.drawable.strength_default)
						binding.txtStrength.setText(R.string.fear_password)
						binding.txtStrength.setTextColor(ContextCompat.getColor(context!!.applicationContext, R.color.fear))
					} else if (pl >= 8 && i == 3) {
						binding.pwStrength1.setImageResource(R.drawable.strength_strong)
						binding.pwStrength2.setImageResource(R.drawable.strength_strong)
						binding.pwStrength3.setImageResource(R.drawable.strength_strong)
						binding.txtStrength.setText(R.string.strong_password)
						binding.txtStrength.setTextColor(ContextCompat.getColor(context!!.applicationContext, R.color.strong))
					}
				}
			}
		})
	}

	override fun onClick(v: View) {
		if (v.id == R.id.bt_back) {
			val mFragmentManager = parentFragmentManager
			mFragmentManager.popBackStack()
		}

		if (v.id == R.id.bt_reset) {
			val mResetCompleteFragment = ResetCompleteFragment()
			val mFragmentManager = parentFragmentManager
			mFragmentManager.beginTransaction().apply {
				replace(R.id.frame_container, mResetCompleteFragment, ResetCompleteFragment::class.java.simpleName)
				addToBackStack(null)
				commit()
			}
		}
	}

	private fun validateEdt(text: String): Int {
		var count = 0
		if (text.matches(Regex("(.*)[a-z](.*)"))) {
			count+=1
		}
		if (text.matches(Regex("(.*)[A-Z](.*)"))) {
			count+=1
		}
		if (text.matches(Regex("(.*)[0-9](.*)"))) {
			count+=1
		}
		return count
	}
}
