package com.example.movieproject

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieproject.models.DETAIL_MOVIE_ID
import com.example.movieproject.models.Screen
import com.example.movieproject.screens.DetailScreen
import com.example.movieproject.screens.FavoriteScreen
import com.example.movieproject.screens.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        // creating NavGraph - defining destinations/composables for routes
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route,
            arguments = listOf(
                navArgument(DETAIL_MOVIE_ID) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(DETAIL_MOVIE_ID)?.let {
                DetailScreen(
                    navController = navController,
                    movieId = it
                )
            }
        }
        composable(route = Screen.FavoriteScreen.route) {
            FavoriteScreen(navController = navController)
        }
    }

}

