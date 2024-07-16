package com.example.lumazaarbusiness.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lumazaarbusiness.R
import com.example.lumazaarbusiness.ui.theme.LumazaarBusinessTheme

@Composable
fun OnboardingScreen(
    image: Int,
    content: @Composable () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "sticker",
            modifier = Modifier.height(300.dp)
        )

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.wave_haikei_1),
                contentDescription = "layer",
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    .padding(
                        bottom = 24.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
            ) {
                content()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnboardingScreenPreview() {
    LumazaarBusinessTheme {
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
}