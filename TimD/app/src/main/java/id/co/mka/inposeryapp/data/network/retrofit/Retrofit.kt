package id.co.mka.inposeryapp.data.network.retrofit

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import id.co.mka.inposeryapp.data.network.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {
    fun getRetrofit(context : Context): Api {
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context)
                .collector(ChuckerCollector(context))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
            )
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-dev.inposery.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(Api::class.java)
    }
}