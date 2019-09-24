package nl.testchamber.apiservice

interface ApiService {

    fun getBrews(apiServiceResponseListener: ApiServiceResponseListener)

    fun getMilkTypes(apiServiceResponseListener: ApiServiceResponseListener)
}