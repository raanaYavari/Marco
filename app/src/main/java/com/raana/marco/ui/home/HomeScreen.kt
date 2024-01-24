package com.raana.marco.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.raana.marco.util.Failed
import com.raana.marco.util.Loaded
import com.raana.marco.util.Loading
import com.raana.marco.util.NotLoaded
import com.raana.marco.util.state

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    Scaffold { paddingValues ->
        val state by viewModel.state()

        Surface(modifier = Modifier.padding(paddingValues)) {

        }
        when (state.places) {
            is Failed -> {

            }

            is Loaded -> {
                LazyColumn() {
                    state.places.data?.let { places ->
                        items(places) {
                            PlaceItem(place = it)
                        }
                    }
                }
            }

            Loading -> {

            }

            NotLoaded -> {

            }
        }
    }
}

