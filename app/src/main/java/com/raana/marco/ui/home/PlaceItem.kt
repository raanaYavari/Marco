package com.raana.marco.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.raana.marco.data.MockData
import com.raana.marco.data.model.Place


@Composable
fun PlaceItem(modifier: Modifier = Modifier, place: Place) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = place.imageUrl,
            contentDescription = place.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = place.name, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = place.description, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview
@Composable
fun PlaceItemPreview() {
    PlaceItem(place = MockData.placeList.first())
}