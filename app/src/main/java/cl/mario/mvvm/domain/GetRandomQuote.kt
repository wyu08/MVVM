package cl.mario.mvvm.domain

import cl.mario.mvvm.data.QuoteRepository
import cl.mario.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuote @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()

        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}