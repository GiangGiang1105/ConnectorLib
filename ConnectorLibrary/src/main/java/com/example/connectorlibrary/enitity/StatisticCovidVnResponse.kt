package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatisticCovidVnResponse(
    @ResponseCode var responseCode: Int,
    var statisticCovid: StatisticCovidVn
): Parcelable