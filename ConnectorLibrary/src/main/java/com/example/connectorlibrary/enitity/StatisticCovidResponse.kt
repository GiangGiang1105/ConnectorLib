package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatisticCovidResponse(
    @ResponseCode val responseCode: Int,
    val statisticCovid: List<StatisticCovid>
): Parcelable