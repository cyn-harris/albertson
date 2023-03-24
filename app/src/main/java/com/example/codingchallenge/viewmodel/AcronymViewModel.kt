package com.example.codingchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.R
import com.example.codingchallenge.model.AcronymRepository
import com.example.codingchallenge.view.AcronymScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Acronym view model.
 *
 * @property repo
 * @constructor Create empty Acronym view model
 */
@HiltViewModel
class AcronymViewModel @Inject constructor(private val repo: AcronymRepository) : ViewModel() {
    private val _state = MutableLiveData(AcronymScreenState())
    val state: LiveData<AcronymScreenState> get() = _state

    var input = MutableLiveData("")

    private val handler = CoroutineExceptionHandler { _, throwable ->
        val errorText = when (throwable) {
            is SerializationException -> R.string.serialization
            is IOException -> R.string.io
            is HttpException -> R.string.http
            else -> R.string.general_exception
        }
        _state.value = _state.value?.copy(isLoading = false, showResultText = false, errorTextId = errorText)
    }

    /**
     * Get words from acronym.
     *
     */
    fun getWordsFromAcronym() = viewModelScope.launch(handler) {
        _state.value = _state.value?.copy(isLoading = true)
        val words = repo.getWordsFromAcronym(input.value!!)
        _state.value = _state.value?.copy(isLoading = false, response = words, showResultText = true)
    }
}
