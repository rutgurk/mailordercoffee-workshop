package nl.testchamber.apiservice

import android.content.Context
import android.util.Log
import nl.testchamber.apiservice.data.ApiRequest
import nl.testchamber.apiservice.data.JsonResponse
import nl.testchamber.apiservice.interfaces.DataProvider
import nl.testchamber.apiservice.interfaces.DataProviderListener
import okhttp3.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class SimpleDataProvider : DataProvider {

    override fun execute(request: ApiRequest, listener: DataProviderListener) {
        val client = OkHttpClient()
        val okRequest = Request.Builder()
                .url(request.uri.toURL())
                .build();
        client.newCall(okRequest).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                buildAndPassResponse("CANNOT PARSE FILE", listener, 1)
            }

            override fun onResponse(call: Call, response: Response) {
                buildAndPassResponse(response.body()!!.string(), listener, 200)
            }
        })
    }

    private fun buildAndPassResponse(body: String, listener: DataProviderListener, code: Int) {
        val response = JsonResponse(code, HashMap<String, String>(), body)
        if (code == 200) {
            listener.onSuccess(response)
        } else {
            listener.onFailure(response)
        }
    }

    companion object {
        private val LOGTAG = SimpleDataProvider::class.java.simpleName
    }
}



