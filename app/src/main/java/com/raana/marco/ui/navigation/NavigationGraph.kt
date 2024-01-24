package com.raana.marco.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raana.marco.ui.detail.DetailScreen
import com.raana.marco.ui.home.HomeScreen
import com.raana.marco.ui.profile.ProfileScreen


sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail")
    data object Profile : Screen("profile")
}

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route
) {
//    val actions = remember(navController) { Actions(navController) }
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(Screen.Home.route) {
            HomeScreen(hiltViewModel())
        }
        composable(Screen.Detail.route) {
            DetailScreen() //TODO add viewModel
        }
        composable(Screen.Profile.route) {
            ProfileScreen() //TODO add viewModel
        }
    }
}