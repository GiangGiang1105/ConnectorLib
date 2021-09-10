package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenderResponse(
    @ResponseCode val responseCode: Int,
    val listGender: List<Gender>
) : Parcelable