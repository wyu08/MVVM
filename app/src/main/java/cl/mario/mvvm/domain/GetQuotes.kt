package cl.mario.mvvm.domain

import cl.mario.mvvm.data.QuoteRepository
import cl.mario.mvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotes @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}