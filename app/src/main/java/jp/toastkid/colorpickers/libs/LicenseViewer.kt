package jp.toastkid.colorpickers.libs

import android.content.Context
import android.support.v7.app.AlertDialog
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

/**
 * License files viewer.
 *
 * Initialize with context.
 * @param context
 *
 * @author toastkidjp
 */
class LicenseViewer(private val context: Context) {

    /**
     * Invoke viewer.
     */
    operator fun invoke() {
        try {
            val assets = context.assets
            val licenseFiles = assets.list(DIRECTORY_OF_LICENSES) ?: return
            val licenseMap = LinkedHashMap<String, String>(licenseFiles.size)
            for (fileName in licenseFiles) {
                val stream = assets.open("$DIRECTORY_OF_LICENSES/$fileName")
                licenseMap[fileName.substring(0, fileName.lastIndexOf("."))] = readUtf8(stream)
                stream.close()
            }
            val items = licenseMap.keys.toTypedArray()
            AlertDialog.Builder(context).setTitle("Licenses")
                    .setItems(items
                    ) { _, index ->
                        AlertDialog.Builder(context)
                                .setTitle(items[index])
                                .setMessage(licenseMap[items[index]])
                                .setCancelable(true)
                                .setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
                                .show()
                    }
                    .setCancelable(true)
                    .setPositiveButton("Close") { d, _ -> d.dismiss() }
                    .show()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    @Throws(IOException::class)
    private fun readUtf8(i: InputStream): String {
        val reader = BufferedReader(InputStreamReader(i, "UTF-8"))

        val content = StringBuilder()
        val lineSeparator = System.getProperty("line.separator")
        var str = reader.readLine()
        while (str != null) {
            content.append(str).append(lineSeparator)
            str = reader.readLine()
        }
        return content.toString()
    }

    companion object {

        /** Directory name.  */
        private const val DIRECTORY_OF_LICENSES = "licenses"
    }
}