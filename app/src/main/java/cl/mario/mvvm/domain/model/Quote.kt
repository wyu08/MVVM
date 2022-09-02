package cl.mario.mvvm.domain.model

import cl.mario.mvvm.data.database.entities.QuoteEntity
import cl.mario.mvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote,author)
fun QuoteEntity.toDomain() = Quote(quote,author)