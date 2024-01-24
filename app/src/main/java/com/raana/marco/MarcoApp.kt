package com.raana.marco


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.raana.marco.ui.component.AppBottomNavigationBar
import com.raana.marco.ui.navigation.NavigationGraph
import com.raana.marco.ui.theme.MarcoTheme

@Composable
fun MyApp() {

    MarcoTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                AppBottomNavigationBar(navController) {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        ) {
            Surface(modifier = Modifier.padding(it)) {
                NavigationGraph(
                    navController = navController,
                )
            }

        }
    }
}