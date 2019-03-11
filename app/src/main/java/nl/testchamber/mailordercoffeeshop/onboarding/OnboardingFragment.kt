package nl.testchamber.mailordercoffeeshop.onboarding

import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nl.testchamber.mailordercoffeeshop.R
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment : androidx.fragment.app.Fragment() {

    companion object {
        val NAME = "name"
        val DRAWABLE = "drawable"

        /**
         * @param name a string to be displayed on the fragment
         * @param drawable drawable to be used in the slide
         */
        fun newInstance(name: String, drawable: Int): androidx.fragment.app.Fragment {
            val fragment = OnboardingFragment()
            val bundle = Bundle()
            bundle.putString(NAME, name)
            bundle.putInt(DRAWABLE, drawable)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        slide_contents.text = arguments?.getString(NAME, "")
        onboarding_image.setImageDrawable(getDrawable(onboarding_image.context, arguments?.getInt(DRAWABLE)!!))
    }
}