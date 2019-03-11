package nl.testchamber.mailordercoffeeshop;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
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
}
