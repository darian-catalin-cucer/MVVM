package cucerdariancatalin.mvvm.domain.model

import cucerdariancatalin.mvvm.data.database.entities.QuoteEntity
import cucerdariancatalin.mvvm.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)