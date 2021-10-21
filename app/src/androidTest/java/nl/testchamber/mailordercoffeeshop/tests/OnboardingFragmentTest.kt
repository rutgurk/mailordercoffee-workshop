package nl.testchamber.mailordercoffeeshop.tests

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.onboarding.OnboardingFragment
import org.junit.Test

class OnboardingFragmentTest {

    @Test
    fun onboardingTest() {
        val bundle = Bundle()
        bundle.putString(OnboardingFragment.NAME, "Testname")
        bundle.putInt(OnboardingFragment.DRAWABLE, R.drawable.onboarding_slide_custom_order)
        launchFragmentInContainer<OnboardingFragment>(bundle)

        onView(withId(R.id.slide_contents)).check(matches(withText("Testname")))
    }
}