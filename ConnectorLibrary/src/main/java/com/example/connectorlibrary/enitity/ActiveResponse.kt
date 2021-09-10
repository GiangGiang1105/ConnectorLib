package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActiveResponse(
    @ResponseCode val responseCode: Int,
    val listActive: List<Active>
): Parcelable