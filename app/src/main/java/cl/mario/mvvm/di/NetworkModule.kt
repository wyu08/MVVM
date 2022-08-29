package cl.mario.mvvm.di

import cl.mario.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://630ce22753a833c5343799dd.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApicliente(retrofit: Retrofit):QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }
}