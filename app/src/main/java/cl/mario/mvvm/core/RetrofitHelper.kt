package cl.mario.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://630ce22753a833c5343799dd.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}