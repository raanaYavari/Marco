package com.raana.marco.ui.component

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raana.marco.ui.navigation.Screen
import com.raana.marco.R

private sealed class NavigationItem(
    val screen: Screen,
    @StringRes val labelResId: Int,
    val icon: ImageVector
) {
    data object Home : NavigationItem(
        screen = Screen.Home,
        labelResId = R.string.home,
        icon = Icons.Outlined.Home,
    )

    data object Search : NavigationItem(
        screen = Screen.Detail,
        labelResId = R.string.detail,
        icon = Icons.Outlined.Search,
    )

    data object Profile : NavigationItem(
        screen = Screen.Profile,
        labelResId = R.string.profile,
        icon = Icons.Outlined.Person,
    )
}


@Composable
fun AppBottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onNavigationSelected: (Screen) -> Unit
) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Profile,
    )
    var selectedItem by remember { mutableIntStateOf(0) }


    NavigationBar(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.toString(),
                        )
                    }, selected = index == selectedItem,
                    label = { Text(text = stringResource(id = item.labelResId)) },
                    onClick = {
                        selectedItem = index
                        onNavigationSelected(item.screen)
                    }
                )
            }
        }

    }
}