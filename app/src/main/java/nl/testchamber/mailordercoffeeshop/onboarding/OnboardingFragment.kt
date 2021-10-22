package nl.testchamber.mailordercoffeeshop.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.databinding.FragmentOnboardingBinding

class OnboardingFragment : androidx.fragment.app.Fragment() {

    private var _binding: FragmentOnboardingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        const val NAME = "name"
        const val DRAWABLE = "drawable"

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.slideContents.text = arguments?.getString(NAME, "")
        binding.onboardingImage.setImageDrawable(
            getDrawable(requireContext(), requireArguments().getInt(DRAWABLE))
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}