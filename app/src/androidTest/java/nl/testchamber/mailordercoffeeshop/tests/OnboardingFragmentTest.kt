package nl.testchamber.mailordercoffeeshop.tests

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.onboarding.OnboardingFragment
import nl.testchamber.mailordercoffeeshop.screens.OnboardingTestScreen
import org.hamcrest.Matchers.not
import org.junit.Test

class OnboardingFragmentTest {

    @Test
    fun onBoardingSlideTest() {
        val bundle = Bundle()
        bundle.putString(OnboardingFragment.NAME, "Testname")
        bundle.putInt(OnboardingFragment.DRAWABLE, R.drawable.onboarding_slide_custom_order)
        launchFragmentInContainer<OnboardingFragment>(bundle)

        OnboardingTestScreen().slideTitle.check(matches(withText("Testname")))

        OnboardingTestScreen().nextButton
        OnboardingTestScreen().closeButton.check(matches(not(isDisplayed())))

        }
}