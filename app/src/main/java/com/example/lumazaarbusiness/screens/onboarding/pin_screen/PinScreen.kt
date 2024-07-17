package com.example.lumazaarbusiness.screens.onboarding.pin_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumazaarbusiness.R
import com.example.lumazaarbusiness.components.CustomButton
import com.example.lumazaarbusiness.components.CustomTextField
import com.example.lumazaarbusiness.components.OnboardingScreen
import com.example.lumazaarbusiness.ui.theme.LumazaarBusinessTheme

@Composable
fun PinScreen(navController: NavController) {
    var pin by remember {
        mutableStateOf("")
    }
    var errorText by remember {
        mutableStateOf<String?>(null)
    }
    val invalidText = stringResource(id = R.string.incorrect_pin)
    val mustBe6Digit = stringResource(id = R.string.pin_must_6_digit)

    OnboardingScreen(
        image = R.drawable.auth_sticker
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomTextField(
                value = pin,
                onValueChanged = {
                    if (it.length == 6) errorText = null
                    if (it.length <= 6) pin = it
                },
                errorText = errorText,
                label = stringResource(id = R.string.pin),
                keyboardType = KeyboardType.Number,
                modifier = Modifier.fillMaxWidth()
            )

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.continue_text),
                onClick = {
                    if (pin.length != 6) {
                        errorText = mustBe6Digit
                    }
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PinScreenPreview() {
    LumazaarBusinessTheme {
        PinScreen(navController = rememberNavController())
    }
}