package nl.testchamber.apiservice.interfaces

import nl.testchamber.apiservice.interfaces.ApiServiceResponseListener

interface ApiService {

    fun getBrews(apiServiceResponseListener: ApiServiceResponseListener)

    fun getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener)
}