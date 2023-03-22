package org.diyorbek.ktor_h1.network

import android.util.Log
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import java.util.logging.LogRecord
import java.util.logging.Logger

object KtorClient {
    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
        install(Logging){
            logger = object : io.ktor.client.features.logging.Logger{
                override fun log(message: String) {
                    Log.d("@@@Ktor", "log: $message")
                }
            }
            level = LogLevel.ALL
        }
        install(HttpTimeout){
            socketTimeoutMillis = 3000
            requestTimeoutMillis = 3000
            connectTimeoutMillis = 3000
        }
    }
}
