package com.example.lumazaarbusiness.screens.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lumazaarbusiness.screens.onboarding.main_screen.MainScreen
import com.example.lumazaarbusiness.screens.onboarding.mobile_no_screen.MobileNoScreen

@Composable
fun OnboardingNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = OnboardingRoute.MOBILE_NO_SCREEN
    ) {
        composable(
            route = OnboardingRoute.MAIN_SCREEN
        ) {
            MainScreen(navController = navController)
        }
        
        composable(
            route = OnboardingRoute.MOBILE_NO_SCREEN
        ) {
            MobileNoScreen(navController = navController)
        }
    }
}