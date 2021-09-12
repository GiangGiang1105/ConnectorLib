package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PeopleInDay(val day: Long = 0, val people: Int = 0) : Parcelable