package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatisticCovidWorldResponse(
    @ResponseCode var responseCode: Int,
    var statisticCovid: StatisticCovidWorld
) : Parcelable