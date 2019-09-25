package nl.testchamber.apiservice

import retrofit2.Response

interface ApiServiceResponseListener {

    fun onSuccess(message: Response<MilkTypeService>)

    fun onFailure(message: String)
}