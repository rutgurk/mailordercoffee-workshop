package nl.testchamber.apiservice.interfaces

import nl.testchamber.apiservice.data.MilkTypeService
import retrofit2.Response

interface ApiServiceResponseListener {

    fun onSuccess(response: Response<MilkTypeService>)

    fun onFailure(message: String)
}