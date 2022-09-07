package cl.mario.mvvm.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.mario.mvvm.domain.GetQuotes
import cl.mario.mvvm.domain.GetRandomQuote
import cl.mario.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {
    @RelaxedMockK
    private lateinit var getQuote: GetQuotes

    @RelaxedMockK
    private lateinit var getRandomQuote: GetRandomQuote

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuote, getRandomQuote)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first time, get all quotes and set the first value`() =
        runTest {
            //Given
            val quoteList = listOf(Quote("Holi", "mariodev"), Quote("Chau", "mariodev"))
            coEvery { getQuote() } returns quoteList

            //When
            quoteViewModel.onCreate()

            //Then
            assert(quoteViewModel.quoteModel.value == quoteList.first())
        }

    @Test
    fun `when randomQuote return a quote set on the livedata`() =
        runTest {
            //Given
            val quote = Quote("hola", "mariodev")
            coEvery { getRandomQuote() } returns quote

            //When
            quoteViewModel.randomQuote()

            //Then
            assert(quoteViewModel.quoteModel.value == quote)
        }

    @Test
    fun `if randomQuote return null keep the last value`() =
        runTest {
            //Given
            val quote = Quote("noseqponer", "mariodev")
            quoteViewModel.quoteModel.value = quote
            coEvery { getRandomQuote() } returns null

            //When
            quoteViewModel.randomQuote()

            //Then
            assert(quoteViewModel.quoteModel.value == quote)

        }
}