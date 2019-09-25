package nl.testchamber.apiservice

import retrofit2.Call
import retrofit2.http.GET

interface RetroFitApiService {

    @GET("5d88a3f13300002c0ed7da8b")
    fun getMilkTypes(): Call<MilkTypeService>

    @GET("5d88a3f13300002c0ed7da8b")
    fun getBrews(): Call<MilkTypeService>
}