package nl.testchamber.apiservice

import android.app.Application
import nl.testchamber.apiservice.interfaces.ApiService
import nl.testchamber.apiservice.interfaces.BrewServiceResponseListener
import nl.testchamber.apiservice.interfaces.MilkTypeServiceResponseListener
import java.net.URI

class HttpApiService : ApiService {
    override fun getBrews(apiServiceResponseListener: BrewServiceResponseListener) {
        val apiRequest = ApiRequest(uri = URI(""))
        LocalFileDataProvider(Application().applicationContext).execute(apiRequest, object : DataProviderListener {
            override fun onSuccess(response: JsonResponse) {

            }

            override fun onFailure(response: JsonResponse) {

            }

        })
    }

    override fun getMilkTypes(milkTypeServiceResponseListener: MilkTypeServiceResponseListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}