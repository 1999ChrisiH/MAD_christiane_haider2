package com.example.movieproject.models

const val DETAIL_MOVIE_ID = "movieID"

sealed class Screen(val route: String) {
    object HomeScreen : Screen(route = "main_screen")
    object FavoriteScreen : Screen(route = "favorite_screen")
    object DetailScreen : Screen(route = "detail_screen/{$DETAIL_MOVIE_ID}") {
        fun setArgs(movieId: String): String {
            return this.route.replace(
                oldValue = "{$DETAIL_MOVIE_ID}",
                newValue = movieId
            )
        }
    }
}