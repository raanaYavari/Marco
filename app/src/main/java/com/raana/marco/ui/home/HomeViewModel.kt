package com.raana.marco.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raana.marco.data.MockData
import com.raana.marco.data.model.Place
import com.raana.marco.util.BaseViewModel
import com.raana.marco.util.LoadableData
import com.raana.marco.util.Loaded
import com.raana.marco.util.Loading
import com.raana.marco.util.NotLoaded
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeViewModel.HomeScreenState>(HomeScreenState()) {

    init {
        getPlaces()
    }

    private fun getPlaces() {
        updateState { copy(places = Loading) }
        viewModelScope.launch {
            delay(500)
            updateState { copy(places = Loaded(MockData.placeList)) }
        }
    }

    data class HomeScreenState(
        val places: LoadableData<List<Place>> = NotLoaded
    )
}