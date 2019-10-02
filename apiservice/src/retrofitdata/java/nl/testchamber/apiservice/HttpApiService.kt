package nl.testchamber.apiservice

import nl.testchamber.apiservice.data.BeverageMenuItem
import nl.testchamber.apiservice.data.MilkTypeService
import nl.testchamber.apiservice.interfaces.ApiService
import nl.testchamber.apiservice.interfaces.MilkTypeServiceResponseListener
import nl.testchamber.apiservice.interfaces.BrewServiceResponseListener
import nl.testchamber.apiservice.interfaces.RetroFitApiService
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

    override fun getBrews(apiServiceResponseListener: BrewServiceResponseListener) {
        apiService.getBrews().enqueue(object : Callback<List<BeverageMenuItem>> {
            override fun onFailure(call: Call<List<BeverageMenuItem>>, t: Throwable) {
                apiServiceResponseListener.onFailure(t.message!!)
            }

            override fun onResponse(call: Call<List<BeverageMenuItem>>, response: Response<List<BeverageMenuItem>>) {
                apiServiceResponseListener.onSuccess(response.body()!!)
            }
        })
    }

    override fun getMilkTypes(milkTypeServiceResponseListener: MilkTypeServiceResponseListener) {
        apiService.getMilkTypes().enqueue(object : Callback<MilkTypeService> {
            override fun onFailure(call: Call<MilkTypeService>, t: Throwable?) {
                milkTypeServiceResponseListener.onFailure(t?.message!!)
            }

            override fun onResponse(call: Call<MilkTypeService>, response: Response<MilkTypeService>?) {
                milkTypeServiceResponseListener.onSuccess(response!!)
            }
        })
    }
}