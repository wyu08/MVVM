package cl.mario.mvvm.data.network

import cl.mario.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("citar")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}