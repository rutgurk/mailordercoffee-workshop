package nl.testchamber.apiservice.interfaces

interface ApiService {

    fun getBrews(apiServiceResponseListener: ApiServiceResponseListener)

    fun getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener)
}