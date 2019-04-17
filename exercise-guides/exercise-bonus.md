# Bonus Exercise: Intended Intents
**Goals:** 
* Learn to keep the scope limited to the app by capturing and validating intents

**Objectives:**
1. Try to write a test that validates the type of data of the intent

<br />

#### Introduction to Intents
Apps consist of Activities, and Activities can invoke other activities (from the same app, but public activities from other apps as well). They do that with 'intents'. An intent is an abstract description of an operation to be performed. An intent has two parts: the type of action to be performed and data expressed as a Uri. An intent to open a website from our app (in another app, such as chrome) would look like this: 
```	
Intent(Intent.ACTION_VIEW, Uri.parse("https://saucelabs.com/resources"))
```
Android knows which apps have the ability to handle "ACTION_VIEW" intents and will open your default app or ask you to select from a list of eligible apps.

#### Testing Intents
If you want to test if your app launches the right intent and contains the right data, you could check if a browser is opened and the right website is opened. 
That means you'd have to automate the browser too. If we go that route, we're not just testing our app, but also testing Android's ability to process intents, and testing our browser's ability to process an incoming intent and open a website. To prevent this broadening of scope, Espresso offers the ability to validate and stub intents.

#### Validating Intents
Instead of an ActivityTestRule to launch an activity, we'll have to use an IntentsTestRule:
```	
	@Rule
	public IntentsTestRule<MyActivity> intentsTestRule =
    	new IntentsTestRule<>(MyActivity.class);
```	

IntentsTestRule is an extension of the ActivityTestRule, this means that we can replace our ActivityTestRule with the IntentsTestRule and all our tests should keep working (don't forget to keep the override that you added in the previous exercise).

To check an intent, we can use the intended() method. The following is an example for how you could check an intent that launches a URL:
```	
	onView(withId(R.id.example_button_that_launches_intent)).perform(click());	
    
    intended(allOf(
             	hasAction(equalTo(Intent.ACTION_VIEW)),
               	hasData(hasHost(equalTo(“https://saucelabs.com “))),
               	hasData(hasPath(equalTo("/resources “)))));
```	

###### source: [https://developer.android.com/reference/android/content/Intent.html](https://developer.android.com/reference/android/content/Intent.html) 
<br />



### Part One: Intention
To be able to validate the intent, you need to know how the intent is constructed by the app.

**The intent is of type:**
* `Intent.ACTION_SENDTO`

 
 **It contains extra's of the following types:**
 * `Intent.EXTRA_EMAIL`  (extra email addresses)
 * `Intent.EXTRA_SUBJECT` (email subject)
 * `Intent.EXTRA_TEXT` (email body text)

<br />

### Part Two: `itended()`
Use the `intended()` method to validate the intent. <br />
Take a look at the Espresso cheat sheet (at [https://developer.android.com](https://developer.android.com/training/testing/espresso/cheat-sheet) or [Select, Click, and Scroll](exercise2.md)) to see which intent matchers are available, and pick the right one(s) for this test case.

If everything passes, checkout the following branch to see the solution:
```
git checkout exercises/solution_exercise_six
```

#### Exercise Tip
Keep it simple at first. Try to write the easiest test you can imagine. If you get that working, you can try testing for more properties of the intent. One by one.

<br />
