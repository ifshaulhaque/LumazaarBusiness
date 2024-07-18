package com.example.lumazaarbusiness.screens.onboarding

import android.content.Context
import android.net.Uri
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

    fun readLastSmsFromNumber(phoneNumber: String, context: Context): String {
        val smsUri = Uri.parse("content://sms/inbox")
        val projection = arrayOf("_id", "address", "body", "date")
        val selection = "address = ?"
        val selectionArgs = arrayOf(phoneNumber)
        val sortOrder = "date DESC"

        var smsContent = "No SMS found"

        val cursor = context.contentResolver.query(smsUri, projection, selection, selectionArgs, sortOrder)
        cursor?.use {
            if (it.moveToFirst()) {
                val bodyIndex = it.getColumnIndexOrThrow("body")
                smsContent = it.getString(bodyIndex)
            }
        }

        return smsContent
    }
}