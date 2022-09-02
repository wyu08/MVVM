package cl.mario.mvvm.domain

import cl.mario.mvvm.data.QuoteRepository
import cl.mario.mvvm.data.database.entities.toDatabase
import cl.mario.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotes @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }

    }

}