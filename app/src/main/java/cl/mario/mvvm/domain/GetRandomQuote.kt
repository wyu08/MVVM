package cl.mario.mvvm.domain

import cl.mario.mvvm.data.model.QuoteModel
import cl.mario.mvvm.data.model.QuoteProvider

class GetRandomQuote {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes

        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}