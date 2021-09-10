package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthResponse(
    @RequestCode val requestCode: Int,
    @ResponseCode val responseCode: Int,
    val user_id: Int,
    val name: String
) : Parcelable