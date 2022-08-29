package cl.mario.mvvm.domain

import cl.mario.mvvm.data.model.QuoteModel
import cl.mario.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuote @Inject constructor(private val quoteProvider: QuoteProvider){
    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes

        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}