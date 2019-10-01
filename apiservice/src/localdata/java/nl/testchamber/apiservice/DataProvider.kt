package nl.testchamber.apiservice

interface DataProvider {

    fun execute(request: ApiRequest, listener: DataProviderListener)
}