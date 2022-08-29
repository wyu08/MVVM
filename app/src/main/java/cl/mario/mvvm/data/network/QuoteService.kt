package cl.mario.mvvm.data.network

import cl.mario.mvvm.core.RetrofitHelper
import cl.mario.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun  getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}