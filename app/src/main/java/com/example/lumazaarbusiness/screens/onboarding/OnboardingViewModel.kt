package com.example.lumazaarbusiness.screens.onboarding

import android.telephony.SmsManager
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(): ViewModel() {
    fun sendSMS(phoneNumber: String, message: String) {
        if (phoneNumber.isNotBlank() && message.isNotBlank()) {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
        }
    }
}