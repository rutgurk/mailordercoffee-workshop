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

    @Before
    public void dismissOnboarding() {
        onView(withId(R.id.close_button)).perform(click());
    }

    @Test
    public void orderOverViewShouldDisplayIngredients() {
        onView(withId(R.id.more_espresso)).perform(click(), click());
        onView(withId(R.id.chocolate)).perform(click());
        onView(withId(R.id.review_order_button)).perform(click());
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withText("Ingredients:\n2 shots of espresso\nChocolate")));
    }
}
