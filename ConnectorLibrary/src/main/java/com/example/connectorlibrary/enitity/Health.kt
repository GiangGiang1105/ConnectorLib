package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.connectorlibrary.base.ListSymptomConverter
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "health")
@Parcelize
@TypeConverters(ListSymptomConverter::class)
data class Health(
    @PrimaryKey(autoGenerate = true)
    val health_id: Int = 0,
    val list_symptom_id: List<Int>,
    val user_id: Int = 0,
    val declare_time: Long = 0
) : Parcelable