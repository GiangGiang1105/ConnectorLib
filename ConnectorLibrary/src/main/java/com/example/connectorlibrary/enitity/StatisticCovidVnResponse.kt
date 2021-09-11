package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatisticCovidVnResponse(
    @ResponseCode val responseCode: Int,
    val statisticCovid: List<StatisticCovidVn>
): Parcelable