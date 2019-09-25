package nl.testchamber.apiservice

import nl.testchamber.apiservice.data.MilkTypeService
import nl.testchamber.apiservice.interfaces.ApiService
import nl.testchamber.apiservice.interfaces.ApiServiceResponseListener
import nl.testchamber.apiservice.interfaces.RetroFitApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HttpApiService : ApiService {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    private val apiService = retrofit.create(RetroFitApiService::class.java)

    override fun getBrews(apiServiceResponseListener: ApiServiceResponseListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener) {
        apiService.getMilkTypes().enqueue(object : Callback<MilkTypeService> {
            override fun onFailure(call: Call<MilkTypeService>?, t: Throwable?) {
                apiServiceResponseListener.onFailure(t?.message!!)
            }

            override fun onResponse(call: Call<MilkTypeService>?, response: Response<MilkTypeService>?) {
                apiServiceResponseListener.onSuccess(response!!)
            }
        })
    }
}