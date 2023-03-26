package com.example.movieproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieproject.models.Movie
import com.example.movieproject.models.getMovieById

@Composable
fun DetailScreen(navController: NavController, movieId: String) {

    var movie: Movie = getMovieById(movieId)


    Card(modifier = Modifier
        .fillMaxWidth()) {

        Column (modifier = Modifier) {
            TopAppBarDetail(navController = navController, title = movie.title)
            MovieRow(movies = movie, onItemClick = {})

            Text(text = "Movie Images", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier
                .fillMaxWidth()
                .size(40.dp))

            LazyRow {
                items(movie.images) { item ->
                    Box(modifier = Modifier
                        .padding(8.dp)){
                        AsyncImage(model = item, contentDescription = movie.title)
                    }
                }
            }
        }
    }
}
@Composable
fun TopAppBarDetail(title: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color(0xFF155081))
    ) {
        Column(
            modifier = Modifier
                .size(70.dp)
                .padding(5.dp), verticalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Arrow Back",
                    tint = Color.White
                )
            }

        }
        Column(modifier = Modifier
            .width(250.dp)
            .padding(15.dp)){
            Text(
                text = title,
                fontSize = 21.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .size(50.dp, 60.dp), verticalArrangement = Arrangement.Center
        ) {
            DropDown()
        }
    }
}
