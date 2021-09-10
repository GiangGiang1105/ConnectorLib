package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SymptomResponse(
    @ResponseCode val responseCode: Int,
    val listSymptom: List<Symptom>
) : Parcelable