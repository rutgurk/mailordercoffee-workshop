package nl.testchamber.apiservice

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HttpApiService: ApiService {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    private val apiService = retrofit.create(RetroFitApiService::class.java)

    override fun getBrews(apiServiceResponseListener: ApiServiceResponseListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener) {
        Log.d("TEST", "now about to start call")
        apiService.getMilkTypes().enqueue(object : Callback<MilkTypeService> {
            override fun onFailure(call: Call<MilkTypeService>?, t: Throwable?) {
                Log.d("TEST", "Failed call")
                apiServiceResponseListener.onFailure(t?.message!!)
            }

            override fun onResponse(call: Call<MilkTypeService>?, response: Response<MilkTypeService>?) {
                Log.d("TEST", "Successful call")
                apiServiceResponseListener.onSuccess(response!!)
            }
        })
    }
}