package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActiveResponse(
    @ResponseCode var responseCode: Int,
    var listActive: List<Active>
): Parcelable