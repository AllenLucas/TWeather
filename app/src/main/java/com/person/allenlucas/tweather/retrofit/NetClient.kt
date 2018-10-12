package com.person.allenlucas.tweather.retrofit

import com.person.allenlucas.tweather.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetClient {

    var mRetrofit: Retrofit? = null

    fun getClient(): Retrofit{
        if (null == mRetrofit) {
            val builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG){
                val loggingInterceptor = HttpLoggingInterceptor()
                        .apply { level = HttpLoggingInterceptor.Level.BODY}
                builder.addInterceptor(loggingInterceptor)
            }
            val client = builder.build()
            mRetrofit = Retrofit.Builder()
                    .baseUrl(NetApi.API_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
        }
        return mRetrofit!!
    }
}