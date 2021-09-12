package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatisticCovidWorldResponse(
    @ResponseCode val responseCode: Int,
    val statisticCovid: StatisticCovidWorld
) : Parcelable