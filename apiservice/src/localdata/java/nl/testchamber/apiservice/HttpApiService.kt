package nl.testchamber.apiservice

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import nl.testchamber.apiservice.data.*
import nl.testchamber.apiservice.interfaces.ApiService
import nl.testchamber.apiservice.interfaces.BrewServiceResponseListener
import nl.testchamber.apiservice.interfaces.DataProviderListener
import nl.testchamber.apiservice.interfaces.MilkTypeServiceResponseListener
import java.net.URI
import com.squareup.moshi.JsonAdapter



class HttpApiService : ApiService {

    override fun getBrews(apiServiceResponseListener: BrewServiceResponseListener) {
        val apiRequest = ApiRequest(uri = URI("http://www.mocky.io/v2/5d8baaad3500006200d47193"))
        val context = GlobalApplication.appContext
        if (context != null) {
            LocalFileDataProvider(context).execute(apiRequest, object : DataProviderListener {
                override fun onSuccess(response: JsonResponse) {
                    val parsedResponse = parseJsonResponseToList(response, BeverageMenuItem::class.java)
                            ?: emptyList()
                    apiServiceResponseListener.onSuccess(parsedResponse)
                }

                override fun onFailure(response: JsonResponse) {

                }

            })
        } else {
            apiServiceResponseListener.onFailure("")
        }
    }

    override fun getMilkTypes(milkTypeServiceResponseListener: MilkTypeServiceResponseListener) {
        val apiRequest = ApiRequest(uri = URI("http://www.mocky.io/v2/5d88a3f13300002c0ed7da8b"))
        val context = GlobalApplication.appContext
        if (context != null) {
            LocalFileDataProvider(context).execute(apiRequest, object : DataProviderListener {
                override fun onSuccess(response: JsonResponse) {
                    val parsedResponse = parseJsonResponse(response, MilkTypeService::class.java)
                            ?: MilkTypeService(MilkTypes(emptyList()))
                    milkTypeServiceResponseListener.onSuccess(parsedResponse)
                }

                override fun onFailure(response: JsonResponse) {

                }

            })
        } else {
            milkTypeServiceResponseListener.onFailure("")
        }
    }

    private fun <T> parseJsonResponseToList(response: JsonResponse, responseObject: Class<T>): List<T>? {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, responseObject)
        val jsonAdapter = moshi.adapter<List<T>>(type)
        var parsedResponse = jsonAdapter.fromJson(response.body)
        return parsedResponse
    }

    private fun <T> parseJsonResponse(response: JsonResponse, responseObject: Class<T>): T? {
        val moshi = Moshi.Builder().build()
        val jsonAdapter:JsonAdapter<T> = moshi.adapter(responseObject)
        var parsedResponse = jsonAdapter.fromJson(response.body)
        return parsedResponse
    }
}