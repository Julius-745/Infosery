package id.co.mka.inposeryapp.onboarding

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.mka.inposeryapp.databinding.SlideOnboardingBinding

class IntroSlideAdapter (private val introSlide : List<IntroSlide>) :
	RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewHolder>() {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): IntroSlideAdapter.IntroSlideViewHolder {
		val binding = SlideOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return IntroSlideViewHolder(binding)
	}

	override fun onBindViewHolder(holder: IntroSlideAdapter.IntroSlideViewHolder, position: Int) {
		holder.bind(introSlide[position])
	}

	override fun getItemCount(): Int {
		return introSlide.size
	}

	inner class IntroSlideViewHolder(private val binding: SlideOnboardingBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(itemOb : IntroSlide) {
			with(binding) {
				titleOb.text = Html.fromHtml(itemOb.title)
				descOb.text = itemOb.desc
				imgOb.setImageResource(itemOb.photo)
			}
		}
	}

}
