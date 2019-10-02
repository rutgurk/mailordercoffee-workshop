package nl.testchamber.apiservice

import android.content.Context
import android.util.Log
import nl.testchamber.apiservice.data.ApiRequest
import nl.testchamber.apiservice.data.JsonResponse
import nl.testchamber.apiservice.interfaces.DataProvider
import nl.testchamber.apiservice.interfaces.DataProviderListener
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class LocalFileDataProvider(private val context: Context) : DataProvider {

    override fun execute(request: ApiRequest, listener: DataProviderListener) {
            try {
                this.buildAndPassResponse(this.readFile(request.method.toString()+request.uri.getPath()), listener, 200)
            } catch (e: IOException) {
                this.buildAndPassResponse("CANNOT PARSE FILE", listener, 1)
                Log.d(LOGTAG, "Asset cannot be read or found")
            }
        }

    protected fun buildAndPassResponse(body: String, listener: DataProviderListener, code: Int) {
        val response = JsonResponse(code, HashMap<String, String>(), body)
        if (code == 200) {
            listener.onSuccess(response)
        } else {
            listener.onFailure(response)
        }

    }

    @Throws(IOException::class)
    protected fun readFile(filePath: String): String {
        val filePath1: InputStream = this.context.assets.open("$filePath.json")
        val output = getString(filePath1)
        filePath1.close()
        return output
    }

    companion object {
        private val LOGTAG = LocalFileDataProvider::class.java.simpleName

        fun getString(`in`: InputStream?): String {
            val input = BufferedReader(InputStreamReader(`in`))
            var output = ""
            try {
                output = input.readText()
            } catch (e: IOException) {
                Log.d(LOGTAG, e.message + "\nResponseCodes reading string from inputStream")
                Log.d(LOGTAG, e.message + "\ngetString : returning empty string")
            } finally {
                try {
                    input.close()
                } catch (e: IOException) {
                    Log.w(LOGTAG, e.message + "\nWarning! Something went wrong closing InputStreamReader. Ignore this message")
                }
            }
            return output
        }
    }
}



