package nl.testchamber.mailordercoffeeshop.tests

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.onboarding.OnboardingFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OnboardingFragmentTest {

    @Test
    fun onboardingTest() {
        launchFragmentInContainer {
            OnboardingFragment.newInstance("Testname", R.drawable.onboarding_slide_custom_order)
        }

        onView(withId(R.id.slide_contents)).perform(click())
        onView(withId(R.id.slide_contents)).check(matches(withText("Testname")))
    }
}