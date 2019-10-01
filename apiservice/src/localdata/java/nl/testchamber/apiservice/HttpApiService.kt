package nl.testchamber.apiservice

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import nl.testchamber.apiservice.data.BeverageMenuItem
import nl.testchamber.apiservice.interfaces.ApiService
import nl.testchamber.apiservice.interfaces.BrewServiceResponseListener
import nl.testchamber.apiservice.interfaces.MilkTypeServiceResponseListener
import java.net.URI

class HttpApiService(private val context: Context) : ApiService {
    override fun getBrews(apiServiceResponseListener: BrewServiceResponseListener) {
        val apiRequest = ApiRequest(uri = URI("http://www.mocky.io/v2/5d8baaad3500006200d47193"))

        LocalFileDataProvider(context).execute(apiRequest, object : DataProviderListener {
            override fun onSuccess(response: JsonResponse) {
                apiServiceResponseListener.onSuccess(parseJsonResponse(response))
            }

            override fun onFailure(response: JsonResponse) {

            }

        })
    }

    override fun getMilkTypes(milkTypeServiceResponseListener: MilkTypeServiceResponseListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun parseJsonResponse(response: JsonResponse): List<BeverageMenuItem> {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, BeverageMenuItem::class.java)
        val jsonAdapter = moshi.adapter<List<BeverageMenuItem>>(type)
        var beverages = jsonAdapter.fromJson(response.body)
        if (beverages == null) {
            beverages = emptyList()
        }
        return beverages
    }

}