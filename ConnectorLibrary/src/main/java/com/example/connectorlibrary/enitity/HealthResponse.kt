package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HealthResponse(
    @RequestCode val requestCode: Int,
    @ResponseCode val responseCode: Int,
    val health_id: Int?,
    val listHealths: List<Health>,
) : Parcelable