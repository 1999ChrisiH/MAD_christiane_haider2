package com.example.movieproject.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieproject.models.Movie
import com.example.movieproject.models.getMovieById
import com.example.movieproject.widgets.MovieRow
import com.example.movieproject.widgets.SimpleAppBar

@Composable
fun DetailScreen(navController: NavController, movieId: String) {

    var movie: Movie = getMovieById(movieId)

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier) {
            SimpleAppBar(navController = navController, title = movie.title)
            MovieRow(movies = movie, onItemClick = {})

            Text(
                text = "Movie Images",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(55.dp)
                    .padding(14.dp)
            )

            LazyRow {
                items(movie.images) { item ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AsyncImage(model = item, contentDescription = movie.title)
                    }
                }
            }
        }
    }
}

