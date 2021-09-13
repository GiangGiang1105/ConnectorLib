package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "symptom")
@Parcelize
data class  Symptom(
    @PrimaryKey(autoGenerate = true) val symptom_id: Int = 0,
    val status_id: Int = 0,
    val symptom_name: String = ""
) : Parcelable