package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(
    @ResponseCode val responseCode: Int,
    @RequestCode val requestCode: Int,
    val listUser: List<User>?,
    val user: User?,
    val user_id: Int?
) : Parcelable