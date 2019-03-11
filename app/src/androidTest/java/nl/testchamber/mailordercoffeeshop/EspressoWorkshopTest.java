package nl.testchamber.mailordercoffeeshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.platform.app.InstrumentationRegistry;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;

public class EspressoWorkshopTest {

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule = new IntentsTestRule<MainActivity>(MainActivity.class) {
        @Override
        public void beforeActivityLaunched() {
            super.beforeActivityLaunched();


            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

            // Solution one
            SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE).edit();
            editor.putBoolean("is_first_launch", false);
            editor.commit();

            // Alternate Solution
//            SharedPreferencesUtil.INSTANCE.setIsFirstLaunchToFalse(context);
        }
    };

    @Test
    public void orderOverViewShouldDisplayIngredients() {
        onView(withId(R.id.more_espresso)).perform(click(), click());
        onView(withId(R.id.chocolate)).perform(click());
        onView(withId(R.id.review_order_button)).perform(click());
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withText("Ingredients:\n2 shots of espresso\nChocolate")));
    }

    @Test
    public void shouldBeAbleToSelectAnItemInTheRecyclerView() {
        onView(withId(R.id.use_menu)).perform(click());
        onView(withId(R.id.beverage_recycler_view))
                .perform(RecyclerViewActions.actionOnItem(hasDescendant(withText("CON PANNA")), click()));
        onView(withId(R.id.beverage_detail_title)).check(matches(withText("Con Panna")));
    }

    @Test
    public void shouldSendAnIntentContainingTheRightOrderName() {
        onView(withId(R.id.more_espresso)).perform(click(), click());
        onView(withId(R.id.chocolate)).perform(click());
        onView(withId(R.id.review_order_button)).perform(click());
        onView(withId(R.id.name_text_box)).perform(scrollTo(), typeText("My name"));
        onView(withId(R.id.custom_order_name_box)).perform(scrollTo(), typeText("Custom Order Name"));
        onView(withId(R.id.mail_order_button)).perform(scrollTo(), click());

        intended(allOf(
                hasAction(equalTo(Intent.ACTION_SENDTO)),
                hasExtra(Intent.EXTRA_SUBJECT, "Order: My name - Custom Order Name")));

    }
}
