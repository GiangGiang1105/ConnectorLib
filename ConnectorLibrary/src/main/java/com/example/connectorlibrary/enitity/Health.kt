package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.sql.Date
import java.sql.Timestamp

@Entity(tableName = "health")
@Parcelize
data class Health(
    @PrimaryKey(autoGenerate = true)
    val health_id: Int = 0,
    val symptom_id: Int = 0,
    val user_id: Int = 0,
    val declare_time: String = ""
) : Parcelable