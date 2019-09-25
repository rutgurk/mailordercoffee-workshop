package nl.testchamber.apiservice

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.awaitResponse

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class APIServiceIntegrationTest {

    @Test
    fun getMilkTypes() {
        var expectedTypes = listOf<String>("No Milk", "Soy", "Low fat", "Half & half", "Cream", "Custom %")

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

    //Todo: create test for HttpApiService.getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener)
}
