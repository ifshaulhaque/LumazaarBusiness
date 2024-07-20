package com.example.lumazaarbusiness.screens.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.lumazaarbusiness.ui.theme.LumazaarBusinessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumazaarBusinessTheme {
                Scaffold { innerPadding ->
                    OnboardingNavGraph(navController = rememberNavController())
                }
            }
        }
    }
}