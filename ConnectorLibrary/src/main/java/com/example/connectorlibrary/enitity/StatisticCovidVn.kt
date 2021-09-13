package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "statistic_covid_vn")
@Parcelize
data class StatisticCovidVn(
    @PrimaryKey(autoGenerate = true) var statistic_id: Int = 0,
    @SerializedName("updated")
    var updated: Long = 0,
    @SerializedName("cases")
    var cases: Int = 0,
    @SerializedName("deaths")
    var deaths: Int = 0,
    @SerializedName("recovered")
    var recovered: Int = 0,
    @SerializedName("country")
    var country: String) : Parcelable