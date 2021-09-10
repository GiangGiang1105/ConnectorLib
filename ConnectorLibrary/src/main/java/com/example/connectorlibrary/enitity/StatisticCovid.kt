package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "statistic_covid")
@Parcelize
data class StatisticCovid(
    @PrimaryKey(autoGenerate = true) val statistic_id: Int = 0,
    val dead_number: Double = 0.0,
    val recovered_number: Double = 0.0,
    val case_number: Double = 0.0,
    val current_time: String = "") : Parcelable