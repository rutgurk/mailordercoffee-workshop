package nl.testchamber.mailordercoffeeshop.tests

import androidx.test.espresso.intent.rule.IntentsTestRule
import nl.testchamber.mailordercoffeeshop.MainActivity
import android.content.SharedPreferences
import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.action.ViewActions
import nl.testchamber.mailordercoffeeshop.R
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import nl.testchamber.mailordercoffeeshop.SharedPreferencesUtil
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EspressoWorkshopTest {
    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        SharedPreferencesUtil.setIsFirstLaunchToFalse(InstrumentationRegistry.getInstrumentation().targetContext)
        Intents.init()
        // Solution one
//            val editor =
//                context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE).edit()
//            editor.putBoolean("is_first_launch", false)
//            editor.commit()

         scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
        scenario.close()
    }

    // For the 'Plus button' I used a hardcoded string. But if a developer has added the text
    // to the Android resources, then it's also available using R.string.*
    // but it's still possible to use "Review order" instead of R.string.review_order_button
    @Test
    fun orderOverViewShouldDisplayIngredients() {
        Espresso.onView(ViewMatchers.withText("+"))
            .perform(ViewActions.click(), ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.chocolate)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(R.string.review_order_button))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.beverage_detail_ingredients))
            .check(ViewAssertions.matches(ViewMatchers.withText("Ingredients:\n2 shots of espresso\nChocolate")))
    }

    @Test
    fun shouldBeAbleToSelectAnItemInTheRecyclerView() {
        Espresso.onView(ViewMatchers.withId(R.id.use_menu)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.beverage_recycler_view))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withText("CON PANNA")
                    ), ViewActions.click()
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.beverage_detail_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Con Panna")))
    }

    @Test
    fun shouldSendAnIntentContainingTheRightOrderName() {
        Espresso.onView(ViewMatchers.withText("+"))
            .perform(ViewActions.click(), ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.chocolate)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(R.string.review_order_button))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.name_text_box))
            .perform(ViewActions.scrollTo(), ViewActions.typeText("My name"))
        Espresso.onView(ViewMatchers.withId(R.id.custom_order_name_box))
            .perform(ViewActions.scrollTo(), ViewActions.typeText("Custom Order Name"))
        Espresso.onView(ViewMatchers.withId(R.id.mail_order_button))
            .perform(ViewActions.scrollTo(), ViewActions.click())
        Intents.intended(
            AllOf.allOf(
                IntentMatchers.hasAction(CoreMatchers.equalTo(Intent.ACTION_SENDTO)),
                IntentMatchers.hasExtra(Intent.EXTRA_SUBJECT, "Order: My name - Custom Order Name")
            )
        )
    }
}