package cl.mario.mvvm.data

import cl.mario.mvvm.data.model.QuoteModel
import cl.mario.mvvm.data.model.QuoteProvider
import cl.mario.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api:QuoteService , private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}