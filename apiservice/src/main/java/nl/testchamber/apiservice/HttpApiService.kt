package nl.testchamber.apiservice

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class HttpApiService: ApiService {

    var retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .build()

    val apiService = retrofit.create(RetroFitApiService::class.java);

    override fun getBrews(apiServiceResponseListener: ApiServiceResponseListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener) {
        apiService.getMilkTypes().enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                apiServiceResponseListener.onFailure(t?.message!!)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                apiServiceResponseListener.onSuccess(response?.body()!!)
            }
        })
    }
}