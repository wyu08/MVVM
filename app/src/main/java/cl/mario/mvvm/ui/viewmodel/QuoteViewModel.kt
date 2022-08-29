package cl.mario.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.mario.mvvm.data.model.QuoteModel
import cl.mario.mvvm.data.model.QuoteProvider
import cl.mario.mvvm.domain.GetQuotes
import cl.mario.mvvm.domain.GetRandomQuote
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading  = MutableLiveData<Boolean>()

    var getQuotes = GetQuotes()
    var getRandomQuote = GetRandomQuote()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotes()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuote()
        if(quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}