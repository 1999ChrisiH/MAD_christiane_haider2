package com.example.movieproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.movieproject.models.Movie
import com.example.movieproject.models.getMovies
import com.example.movieproject.widgets.MovieRow
import com.example.movieproject.widgets.SimpleAppBar

@Composable
fun FavoriteScreen(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        var movie: List<Movie> = getMovies()
        var hardcodedList: List<Movie> = listOf(movie[1], movie[3], movie[5], movie[7])

        Column(modifier = Modifier.background(color = Color(0xFFABC3D6))) {

            SimpleAppBar(navController = navController, title = "Favorites")

            LazyColumn {
                items(hardcodedList) { movie ->
                    MovieRow(movies = movie, onItemClick = {})
                }
            }
        }
    }
}