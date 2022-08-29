package cl.mario.mvvm.domain

import cl.mario.mvvm.data.QuoteRepository
import cl.mario.mvvm.data.model.QuoteModel

class GetQuotes {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}