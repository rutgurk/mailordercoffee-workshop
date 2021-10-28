package nl.testchamber.mailordercoffeeshop.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.SharedPreferencesUtil
import nl.testchamber.mailordercoffeeshop.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private var currentPage = 0
    private val fragments = ArrayList<androidx.fragment.app.Fragment>()
    private lateinit var onboardingSlides: List<OnboardingSlide>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initOnboardingSlidesList()

        binding.viewPager.adapter = populateOnboardingAdapter()
        setNavigationButtonsBehaviour()
    }

    private fun initOnboardingSlidesList() {
        onboardingSlides = listOf(
            OnboardingSlide(
                getString(R.string.onboarding_create_custom_order),
                R.drawable.onboarding_slide_custom_order
            ),
            OnboardingSlide(
                getString(R.string.onboarding_browse_menu),
                R.drawable.onboarding_slide_recyclerview
            ),
            OnboardingSlide(
                getString(R.string.onboarding_order_by_mail),
                R.drawable.onboarding_slide_orderoverview
            )
        )
    }

    private fun setNavigationButtonsBehaviour() {
        if (currentPage == fragments.size - 1) {
            closeOnboarding()
        } else {
            binding.goOnButton.setOnClickListener {
                var newPosition = currentPage + 1
                binding.viewPager.setCurrentItem(newPosition, true)
                setButtonVisibility(newPosition)
                updateCurrentPagePosition(newPosition)
            }

            binding.closeButton.setOnClickListener {
                closeOnboarding()
            }

            binding.doneButton.setOnClickListener { closeOnboarding() }
        }
    }

    private fun closeOnboarding() {
        startActivity(Intent(this, nl.testchamber.mailordercoffeeshop.MainActivity::class.java))
        SharedPreferencesUtil.setIsFirstLaunchToFalse(applicationContext)
        finish()
    }

    private fun populateOnboardingAdapter(): OnboardingViewPagerAdapter {
        val adapter = OnboardingViewPagerAdapter(supportFragmentManager)
        onboardingSlides.forEach {
            fragments.add(
                OnboardingFragment.newInstance(
                    it.title,
                    it.drawable
                )
            )
        }
        adapter.addFragments(fragments)
        return adapter
    }

        fun setButtonVisibility(position: Int) {
            if (position < fragments.lastIndex) {
                binding.doneButton.visibility = View.GONE
                binding.goOnButton.visibility = View.VISIBLE
            } else {
                binding.goOnButton.visibility = View.GONE
                binding.doneButton.visibility = View.VISIBLE
            }
        }

           fun updateCurrentPagePosition(position: Int) {
                currentPage = position
            }
    }

data class OnboardingSlide(val title: String, val drawable: Int)
