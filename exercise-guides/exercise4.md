# Exercise 4: Breaking the Rules
**Goals:** 
* Learn to use `ActivityTestRule`
* See the possibilities offered by Espresso to use app code

**Objectives:**
1. Modify the app state before it's launched by setting `first_launch` to `false` in the app's `sharedPreferences`.
2. Verify the beverage name on the **Order Overview** screen.

<br />

### Part One: Override `beforeActivityLaunhed`
1. Replace or modify the existing TestRule in `EspressoWorkshopTest.java`, so it looks like the following:
    ```
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
	   public void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        // code we'd like to execute to edit SharedPrefences
        }
    };
    ```
This `@Override` method will implement any code that we want to edit the `SharedPreferences`, for example getting into the app context.

<br />

### Part Two: Modify the `SharedPreferences`
1. Add the following code in the `Override` method from the previous step:
    ```
    super.beforeActivityLaunched();
    Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
    ```
2. Add the following code to gain access to the shared preferences editor:
    ```
    SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE).edit();
    ```
3. Finally, change the app state to `first_launch` = `false`
    
    > Hint: Editing the shared preferences is the same as it is in the app.
    
<br />

### Part Three: Verify and Test
1. Save all and hit the play button next to your test method
2. If everything passes, checkout the next branch to see the full solution
    ```
    git checkout solution/solution_exercise_five
    ```

<br />
