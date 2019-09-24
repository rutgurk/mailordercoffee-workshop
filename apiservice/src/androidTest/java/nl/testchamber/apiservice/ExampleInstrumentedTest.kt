package nl.testchamber.apiservice

import android.content.Context

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("nl.testchamber.apiservice.test", appContext.packageName)
    }

    @Test
    fun testNetworkCall() {
        HttpApiService().getMilkTypes(object : ApiServiceResponseListener {
            override fun onSuccess(message: String) {
                assertEquals("onSucces", message)
                 }

            override fun onFailure(message: String) {
                assertEquals("onFailure", message)
            }

        })
    }
}
