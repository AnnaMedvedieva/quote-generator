package org.company.example.annaunderwood.quotegenerator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.company.example.annaunderwood.quotegenerator.Network.Quote
import org.company.example.annaunderwood.quotegenerator.Network.QuoteApi
import java.lang.Exception





class RandomQuoteViewModel : ViewModel() {

    private val TAG = "vm"


    private val _randomQuote = MutableLiveData<Quote>()

    val randomQuote : LiveData<Quote>
        get() =_randomQuote


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        parceRandomQuote()
    }

     fun parceRandomQuote() {
        coroutineScope.launch {
            val deferredRandomQuote = QuoteApi.retrofitService.getRandomQuote()
            try{
                val resultQuote = deferredRandomQuote.await()
                _randomQuote.value = resultQuote
            }
            catch(e: Exception){

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
