package cl.mario.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.mario.mvvm.model.QuoteModel
import cl.mario.mvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currenQuote = QuoteProvider.random()
        quoteModel.postValue(currenQuote)
    }
}