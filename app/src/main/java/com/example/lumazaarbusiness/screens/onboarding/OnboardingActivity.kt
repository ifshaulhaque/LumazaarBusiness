package com.example.lumazaarbusiness.screens.onboarding

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.lumazaarbusiness.ui.theme.LumazaarBusinessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity: ComponentActivity() {
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted. Continue with SMS reading.
        } else {
            // Permission is denied. Inform the user about the requirement.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumazaarBusinessTheme {
                Scaffold { innerPadding ->
                    requestPermissionLauncher.launch(Manifest.permission.READ_SMS)
                    OnboardingNavGraph(navController = rememberNavController())
                }
            }
        }
    }
}