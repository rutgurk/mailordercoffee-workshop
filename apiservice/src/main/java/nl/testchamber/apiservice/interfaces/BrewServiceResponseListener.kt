package nl.testchamber.apiservice.interfaces

import nl.testchamber.apiservice.data.BeverageMenuItem
import retrofit2.Response

interface BrewServiceResponseListener {

    fun onSuccess(response: Response<List<BeverageMenuItem>>)

    fun onFailure(message: String)
}