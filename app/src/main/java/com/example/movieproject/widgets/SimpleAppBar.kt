package com.example.movieproject.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SimpleAppBar(title: String, navController: NavController) {
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
        Column(
            modifier = Modifier
                .width(250.dp)
                .padding(15.dp)
        ) {
            Text(
                text = title,
                fontSize = 21.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(2f))
        Column(
            modifier = Modifier
                .size(50.dp, 60.dp), verticalArrangement = Arrangement.Center
        ) {
            DropDown(navController)
        }
    }
}