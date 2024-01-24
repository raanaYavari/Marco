package com.raana.marco.util

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState

abstract class BaseViewModel<STATE>(
    initialState: STATE
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val stateStateFlow = _state.asStateFlow()

    val currentState: STATE
        get() {
            return _state.value
        }

    fun updateState(function: STATE.() -> STATE) {
        _state.update { function(it) }
    }
}

@Composable
fun <T : Any> BaseViewModel<T>.state(): State<T> {
    return stateStateFlow.collectAsState()
}