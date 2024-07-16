package com.example.lumazaarbusiness.screens.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lumazaarbusiness.screens.onboarding.main_screen.MainScreen

@Composable
fun OnboardingNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = OnboardingRoute.MAIN_SCREEN
    ) {
        composable(
            route = OnboardingRoute.MAIN_SCREEN
        ) {
            MainScreen(navController = navController)
        }
    }
}