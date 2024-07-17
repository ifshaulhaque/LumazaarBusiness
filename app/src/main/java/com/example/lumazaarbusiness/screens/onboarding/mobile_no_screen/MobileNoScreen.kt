package com.example.lumazaarbusiness.screens.onboarding.mobile_no_screen

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
fun MobileNoScreen(navController: NavController) {
    var mobileNo by remember {
        mutableStateOf("")
    }
    var errorText by remember {
        mutableStateOf<String?>(null)
    }
    val invalidText = stringResource(id = R.string.invalid)

    OnboardingScreen(
        image = R.drawable.auth_sticker
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomTextField(
                value = mobileNo,
                onValueChanged = {
                    if (it.length == 10) errorText = null
                    if (it.length <= 10) mobileNo = it
                },
                errorText = errorText,
                label = stringResource(id = R.string.mobile_no),
                keyboardType = KeyboardType.Number,
                modifier = Modifier.fillMaxWidth()
            )

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.verify),
                onClick = {
                    if (mobileNo.length != 10) {
                        errorText = invalidText
                    }
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MobileNoScreenPreview() {
    LumazaarBusinessTheme {
        MobileNoScreen(navController = rememberNavController())
    }
}