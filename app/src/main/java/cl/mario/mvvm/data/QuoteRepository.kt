package cl.mario.mvvm.data

import cl.mario.mvvm.data.model.QuoteModel
import cl.mario.mvvm.data.model.QuoteProvider
import cl.mario.mvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}