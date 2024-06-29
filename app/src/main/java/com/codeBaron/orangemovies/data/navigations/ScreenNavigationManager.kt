package com.codeBaron.orangemovies.data.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeBaron.orangemovies.MainActivity
import com.codeBaron.orangemovies.ui.screens.HomeScreen

@Composable
fun ScreenNavigationManager(
    mainActivity: MainActivity,
    internetState: Boolean
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenDestinations.home_screen.name) {
        composable(ScreenDestinations.home_screen.name) {
            HomeScreen(navController, mainActivity, internetState)
        }
    }
}