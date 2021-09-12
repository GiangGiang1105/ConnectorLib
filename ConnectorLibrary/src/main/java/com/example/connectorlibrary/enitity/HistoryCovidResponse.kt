package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryCovidResponse(
    @RequestCode val requestCode: Int,
    @ResponseCode val responseCode: Int,
    val listHistoryCovid: List<HistoryCovid>
) : Parcelable
