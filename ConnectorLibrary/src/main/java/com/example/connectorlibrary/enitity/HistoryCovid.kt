package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "history_covid")
data class HistoryCovid(
    @PrimaryKey(autoGenerate = true)
    val history_id : Int = 0,
    val area : String = "all",
    val date: Long = 0,
    val cases: Long = 0
): Parcelable