package com.example.lumazaarbusiness.screens.onboarding.mobile_no_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumazaarbusiness.R
import com.example.lumazaarbusiness.components.CustomButton
import com.example.lumazaarbusiness.components.CustomTextField
import com.example.lumazaarbusiness.components.OnboardingScreen
import com.example.lumazaarbusiness.screens.onboarding.OnboardingRoute
import com.example.lumazaarbusiness.screens.onboarding.OnboardingViewModel
import com.example.lumazaarbusiness.ui.theme.LumazaarBusinessTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MobileNoScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel? = hiltViewModel()
) {
    val context = LocalContext.current

    var mobileNo by remember {
        mutableStateOf("")
    }
    var errorText by remember {
        mutableStateOf<String?>(null)
    }
    val invalidText = stringResource(id = R.string.invalid)
    var showVerifyingDialog by remember {
        mutableStateOf(false)
    }

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
                text = stringResource(id = R.string.send_sms),
                onClick = {
                    if (mobileNo.length != 10) {
                        errorText = invalidText
                    } else {
                        val otp = Random.nextInt(100000, 1000000).toString()
                        onboardingViewModel?.sendSMS(mobileNo, otp)

                        showVerifyingDialog = true
                        var timmer = 59

                        CoroutineScope(Dispatchers.Main).launch {
                            while (timmer >= 0) {
                                delay(1000)
                                timmer -= 1
                                if (timmer % 5 == 0) {
                                    val sms = onboardingViewModel?.readLastSmsFromNumber(mobileNo, context)
                                    Toast.makeText(context, sms, Toast.LENGTH_SHORT).show()
                                    if (!sms.isNullOrEmpty() && sms == otp) {
                                        showVerifyingDialog = false
                                        navController.navigate(route = OnboardingRoute.PIN_SCREEN)
                                        cancel()
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }
    }

    if (showVerifyingDialog) {
        AlertDialog(
            onDismissRequest = {
                showVerifyingDialog = false
            }, confirmButton = { },
            title = {
                Text(text = stringResource(id = R.string.verifying))
            },
            properties = DialogProperties(dismissOnClickOutside = false)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MobileNoScreenPreview() {
    LumazaarBusinessTheme {
        MobileNoScreen(navController = rememberNavController())
    }
}