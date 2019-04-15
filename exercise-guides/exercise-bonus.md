# Bonus Exercise: Intended Intents
**Goals:** 
* Learn to keep the scope limited to the app by capturing and validating intents

**Objectives:**
1. Try to write a test that validates the type of data of the intent

<br />

### Part One: Intention
1. The intent is of type:
    ```
    Intent.ACTION_SENDTO
    ```
Therefore it contains extra's (data) of the following types:
    * `Intent.EXTRA_EMAIL`  (extra email addresses)
    * `Intent.EXTRA_SUBJECT` (email subject)
    * `Intent.EXTRA_TEXT` (email body text)

<br />

### Part Two: `itended()`
1. Use the `intended()` method to validate the intent

#### Exercise Tip
Keep it simple at first. Try to write the easiest test you can imagine. If you get that working, you can try testing for more properties of the intent. One by one.

<br />
