package com.example.movieproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieproject.widgets.DropDown
import com.example.movieproject.widgets.MovieList

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        TopAppBarHome(navController)
        MovieList(navController = navController)
    }
}

@Composable
fun TopAppBarHome(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color(0xFF155081))
    ) {
        Column(
            modifier = Modifier
                .size(100.dp)
                .padding(15.dp), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Movies",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .size(50.dp, 60.dp), verticalArrangement = Arrangement.Center
        ) {
            DropDown(navController)
        }
    }
}