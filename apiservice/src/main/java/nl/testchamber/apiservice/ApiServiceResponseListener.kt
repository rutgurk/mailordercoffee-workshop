package nl.testchamber.apiservice

interface ApiServiceResponseListener {

    fun onSuccess(message: String)

    fun onFailure(message: String)
}