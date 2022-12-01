package cucerdariancatalin.mvvm.domain

import cucerdariancatalin.mvvm.data.QuoteRepository
import cucerdariancatalin.mvvm.data.database.entities.toDatabase
import cucerdariancatalin.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}