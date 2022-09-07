package cl.mario.mvvm.domain

import cl.mario.mvvm.data.QuoteRepository
import cl.mario.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomQuoteTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuote: GetRandomQuote

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuote = GetRandomQuote(quoteRepository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()
        //When
        val response = getRandomQuote()
        //Then
        assert(response == null)
    }

    @Test
    fun `when database is not empty then return quote`() = runBlocking {
        //Given
        val quoteList = listOf(Quote("Holi", "mariodev"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList
        //When
        val response = getRandomQuote()
        //Then
        assert(response == quoteList.first())
    }

}