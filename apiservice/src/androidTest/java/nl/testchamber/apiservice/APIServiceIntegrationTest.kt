package nl.testchamber.apiservice

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import nl.testchamber.apiservice.data.MilkTypeService
import nl.testchamber.apiservice.interfaces.ApiServiceResponseListener
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class APIServiceIntegrationTest {

    @Test
    fun getHttpServiceMilkTypes() {
        var expectedTypes = listOf("No Milk", "Soy", "Low fat", "Half & half", "Cream", "Custom %")
        val actualTypes = runBlocking {
            suspendCoroutine<List<String>> { cont ->
                HttpApiService().getMilkTypes(object : ApiServiceResponseListener {
                    override fun onSuccess(response: Response<MilkTypeService>) {
                        cont.resume(response.body()!!.milkTypes.types)
                    }

                    override fun onFailure(message: String) {
                        cont.resumeWithException(Throwable(message))
                    }
                })
            }
        }
        assertEquals(expectedTypes, actualTypes)
    }
}
