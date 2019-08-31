package nl.testchamber.mailordercoffeeshop;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    // The @Before annotation let's you run a method before each test
    // With this annotation the onboarding will be dismissed for each test that we write
    @Before
    public void dismissOnboarding() {
        onView(withId(R.id.close_button)).perform(click());
    }

    // For the 'Plus button' I used a hardcoded string. But if a developer has added the text
    // to the Android resources, then it's also available using R.string.*
    // but it's still possible to use "Review order" instead of R.string.review_order_button
    @Test
    public void orderOverViewShouldDisplayIngredients() {
        onView(withText("+")).perform(click(), click());
        onView(withId(R.id.chocolate)).perform(click());
        onView(withText(R.string.review_order_button)).perform(click());
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withText("Ingredients:\n2 shots of espresso\nChocolate")));
    }
}
