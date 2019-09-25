package nl.testchamber.apiservice

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response
import retrofit2.awaitResponse
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class APIServiceIntegrationTest {

    @Test
    fun getMilkTypes() {
        var expectedTypes = listOf("No Milk", "Soy", "Low fat", "Half & half", "Cream", "Custom %")

        runBlocking {
            val response = try {
                HttpApiService().apiService.getMilkTypes().awaitResponse()
            } catch (e: Exception) {
                fail("Request failed, expected success")
                return@runBlocking
            }
            assertEquals(expectedTypes, response.body()?.milkTypes?.types)
        }
    }

    @Test
    fun getHttpServiceMilkTypes() {
        var expectedTypes = listOf("No Milk", "Soy", "Low fat", "Half & half", "Cream", "Custom %")
        val actualTypes = runBlocking {
            suspendCoroutine<List<String>> { cont ->
                HttpApiService().getMilkTypes(object : ApiServiceResponseListener {
                    override fun onSuccess(message: Response<MilkTypeService>) {
                        cont.resume(message.body()!!.milkTypes?.types)
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
