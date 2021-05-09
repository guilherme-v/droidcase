package br.curitiba.android.remote.service

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GithubServiceFactory {

    private val gson = Gson()
    private const val baseURL = "https://api.github.com/"

    fun createGithubService(printLogs: Boolean): GithubService {
        val client = OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor(printLogs = printLogs))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()

        return create(httpClient = client)
    }

    private fun createLoggingInterceptor(printLogs: Boolean): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        if (printLogs) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        return interceptor;
    }

    private fun create(httpClient: OkHttpClient): GithubService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(GithubService::class.java)
    }
}