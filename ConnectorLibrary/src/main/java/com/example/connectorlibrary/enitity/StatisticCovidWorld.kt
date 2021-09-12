package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "statistic_covid_world")
@Parcelize
data class StatisticCovidWorld(
    @PrimaryKey(autoGenerate = true) val statistic_id: Int = 0,
    @SerializedName("updated")
    val updated: Long = 0,
    @SerializedName("cases")
    val cases: Int = 0,
    @SerializedName("deaths")
    val deaths: Int = 0,
    @SerializedName("recovered")
    val recovered: Int = 0
) : Parcelable