package com.example.movieproject.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieproject.models.Movie
import com.example.movieproject.models.Screen
import com.example.movieproject.models.getMovies

@Composable
fun MovieList(movies: List<Movie> = getMovies(), navController: NavController) {
    LazyColumn() {
        items(movies) { movie ->
            MovieRow(movie) { movieId ->
                // Log.d("MainContent", "Value: $movieId")
                navController.navigate(
                    route = Screen.DetailScreen.setArgs(
                        movieId = movie.id
                    )
                )
            }
        }
    }
}