package com.example.movieproject.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieproject.models.Screen

@Composable
fun DropDown(navController: NavController) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(contentAlignment = Alignment.CenterStart) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu")
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                onClick = {
                    navController.navigate(Screen.FavoriteScreen.route)
                },
            ) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "filled heart")
                Text(text = "  Favorites", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}