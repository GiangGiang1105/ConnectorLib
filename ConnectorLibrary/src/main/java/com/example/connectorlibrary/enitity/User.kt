package com.example.connectorlibrary.enitity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.sql.Date

@Entity(tableName = "user")
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id: Int = 0,
    val name: String = "",
    val phone_number: String = "",
    val passport_number: String = "",
    val birthday: Date,
    val gender_id: Int = 0,
    val email: String = "",
    val address: String = "",
    val active_id : Int = 0
) : Parcelable