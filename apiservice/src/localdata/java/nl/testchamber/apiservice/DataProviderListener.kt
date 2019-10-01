package nl.testchamber.apiservice

interface DataProviderListener {
    fun onSuccess(response: JsonResponse)
    fun onFailure(response: JsonResponse)
}