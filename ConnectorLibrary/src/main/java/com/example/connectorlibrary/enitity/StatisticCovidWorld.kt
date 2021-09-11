package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "statistic_covid_world")
@Parcelize
data class StatisticCovidWorld(
    @PrimaryKey(autoGenerate = true) val statistic_id: Int = 0,
    val updated: Long = 0,
    val cases: Int = 0,
    val deaths: Int = 0,
    val recovered: Int = 0,
    val country: String
) : Parcelable