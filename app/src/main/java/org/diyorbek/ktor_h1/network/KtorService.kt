package org.diyorbek.ktor_h1.network

import io.ktor.client.request.*
import org.diyorbek.ktor_h1.model.Beer

object KtorService {
    suspend fun getBeer(): Beer{
        return KtorClient.httpClient.use {
            it.get("https://random-data-api.com/api/v2/beers")
        }
    }
}