package com.example.lumazaarbusiness.screens.onboarding.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumazaarbusiness.R
import com.example.lumazaarbusiness.components.CustomButton
import com.example.lumazaarbusiness.components.OnboardingScreen

@Composable
fun MainScreen(navController: NavController) {
    OnboardingScreen(
        image = R.drawable.auth_sticker
    ) {
        Column {
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.login)
            ) {}
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.sign_up)
            ) {}
        }
    }
}

@Composable
@Preview (showBackground = true)
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}