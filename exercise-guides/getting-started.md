# Espresso SauceCon Workshop Exercises

> ##### Disclaimer: For Demonstration Purposes Only
> The code provided in the exercise scripts is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. These scripts are provided for educational and demonstration purposes only, and should not be used in production. Issues regarding these scripts should be submitted through GitHub. These scripts are maintained by the Technical Services and Info Development teams at Sauce Labs.

## Prerequisites

Before you begin, consult the parent [README](../README.md) for instructions on how to complete the following:

* [Install Git](../README.md#install-git)
* [Install JDK](../README.md#install-the-jdk)
* [Install Gradle](../README.md#install-gradle)
* [Install Android Studio](../README.md#install-android-studio)

Download the latest [release](https://github.com/saucelabs-training/saucecon19-espresso-workshop/releases) archive and import the project into your local environment and begin experimenting with creating your own automated Selenium tests!

<br />

## Exercise List
1. [Dismiss Onboarding Screen](exercise1.md)
2. [Select, Click, and Scroll](exercise2.md)
3. [Recycle with Espresso](exercise3.md)
4. [Breaking the Rules](exercise4.md)
5. [Bonus Exercise: Intended Intents](exercise-bonus.md)

<br />

## Sample App Features
The **MailOrderCoffeeShop** app has 4 parts: 
* onboarding
* custom order
* menu
* order overview.

### Onboarding
The onboarding showcases the features of the app.
* There's an 'x' in the top left that dismisses the onboarding.
* You can swipe to view different onboarding screens.
* You can use the 'next arrow' in the bottom right to view the next onboarding screen.
* The 'next arrow' makes place for the 'done icon' on the last onboarding screen, which dismisses the onboarding.
* After being dismissed the onboarding will not be started again. Only after a clean install or after all app settings have been deleted.

### Custom Order
The custom order screen allows you to select different ingredients for your beverage.
* There are two buttons at the top, one for custom order and the other for the menu.
* The custom order button is disabled while on the custom order screen.
* The amount of espresso shots is controlled using the "+" and "-" buttons
* A counter shows the currently selected amount of shots
* If you try to select less than 0 shots (using the "-" button), a toast will be displayed.
* You can choose whether you'd like to have hot or cold espresso shots by using the "hot switch".
* The "hot switch" is set to true/on by default
* There's a spinner when you can select a type of milk to be added
* If the spinner is set to anything other than "no milk", you can select the milk preparation using radio buttons.
* If the milk type is set to custom % you get the ability to select a fat % using a seekbar (slider)
* The 'review order button' takes you to the 'order overview' screen
* Each order has to have at least 1 espresso shot: If you try to go to the order overview with 0 shots, a toast will be displayed.

### Menu
The menu screen allows you to pick a beverage from a scrollable list.
* There are two buttons at the top, one for custom order and the other for the menu.
* The menu button is disabled while on the menu screen.
*The list should be scrollable
* Each item on the list should have an icon, name and volume (in ml.)
* The icon should represent the beverage volume: 0-60ml == low, 61-180 == medium, 180+ == full.
* Clicking on an item should take you to the order overview screen.

### Order Overview
Allows you to review the order and submit the order using email
* Shows the beverage name for items from the menu
* The cup image should represent the beverage volume: 0-60ml == low, 61-180 == medium, 180+ == full
* The ingredients list should show all the ingredients, one for each line
* You can enter your name in the 'name edit text'
* You can enter your email address in the 'email edit text'
* If it's a custom order there's an additional field where you can give your order a name.
* The submit button launches an email app and supplies the details for you.
* Entering your name is mandatory, if it's a custom order the order name is also mandatory. If you press submit while these fields are empty, error messages are displayed below the text fields.
