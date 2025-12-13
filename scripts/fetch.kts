#!/usr/bin/env kotlin

import java.io.File
import java.net.HttpURLConnection
import java.net.URL

val url = "https://example.com/test.txt"
val output = File("downloaded.txt")

val conn = URL(url).openConnection() as HttpURLConnection
conn.connectTimeout = 15_000
conn.readTimeout = 15_000

conn.inputStream.use { input ->
    output.outputStream().use { out ->
        input.copyTo(out)
    }
}

println("Downloaded ${output.length()} bytes")
