package com.myapp.translatorapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.translatorapp.domain.repository.GetTranslationRepository
import com.myapp.translatorapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranslatorFragmentViewModel @Inject constructor(
    private val repository: GetTranslationRepository
): ViewModel() {

    var state = MutableStateFlow(TranslationState())
    private set

    fun onEnterText(text: String) {
        viewModelScope.launch {
            repository.getTranslation(text)
                .onEach { response ->
                    when(response) {
                        is Resource.Success -> {
                            state.value = state.value.copy(
                                text = response.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            state.value = state.value.copy(
                                text = response.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            state.value = state.value.copy(
                                text = response.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }

}