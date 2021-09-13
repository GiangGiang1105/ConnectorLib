package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.connectorlibrary.base.DateConverter
import com.example.connectorlibrary.base.ListSymptomConverter
import kotlinx.android.parcel.Parcelize
import java.sql.Date

@Entity(tableName = "health")
@Parcelize
@TypeConverters(DateConverter::class, ListSymptomConverter::class)
data class Health(
    @PrimaryKey(autoGenerate = true)
    val health_id: Int = 0,
    val symptom_id: List<Int>,
    val user_id: Int = 0,
    val declare_time: Date
) : Parcelable