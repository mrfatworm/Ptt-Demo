package com.mrfatworm.pttdemo.data.remote

import com.mrfatworm.pttdemo.data.model.LoginParam
import com.mrfatworm.pttdemo.data.model.UserData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class PttHttpClientImpl : PttHttpClient {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }

    private fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom("https://4f77e61f-701d-4e78-9585-a47ff0f258d7.mock.pstmn.io")
            path(path)
        }
    }

    override suspend fun login(userId: String, password: String): UserData = client.post {
        apiUrl("/login")
        contentType(ContentType.Application.Json)
        setBody(LoginParam(userId, password))
    }.body()
}


