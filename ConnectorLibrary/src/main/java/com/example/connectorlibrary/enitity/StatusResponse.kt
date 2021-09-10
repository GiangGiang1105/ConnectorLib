package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatusResponse(
    @ResponseCode val responseCode: Int,
    val listStatuses: List<Status>
) : Parcelable