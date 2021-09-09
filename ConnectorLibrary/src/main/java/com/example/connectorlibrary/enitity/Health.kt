package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Date

@Parcelize
data class Health(
    val user_id: Int = 0,
    val name: String = "",
    val phone_number: String = "",
    val passport_number: String = "",
    val birthday: Date,
    val gender_id: String = "",
    val email: String = "",
    val address: String = ""
) : Parcelable