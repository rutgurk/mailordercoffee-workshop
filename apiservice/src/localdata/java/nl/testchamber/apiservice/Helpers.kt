package nl.testchamber.apiservice

/**
 * Created by rutger on 09/02/2018.
 */
object Helpers {

    fun addToExistingMap(map: Map<String, String>, existingMap: MutableMap<String, String>): MutableMap<String, String> {
        for ((key, value) in map) {
            existingMap[key] = value
        }
        return existingMap
    }
}
