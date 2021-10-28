package nl.testchamber.mailordercoffeeshop.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.base.Screen

class OnboardingScreen: Screen {

    val closeButton = onView(withId(R.id.close_button))
    val nextButton = onView(withId(R.id.go_on_button))
    val slideTitle = onView(withId(R.id.slide_contents))
    val image = onView(withId(R.id.onboarding_image))
    val doneButton = onView(withId(R.id.done_button))

    fun goToNextSlide(): OnboardingScreen {
        nextButton.perform(click())
        return this
    }



}