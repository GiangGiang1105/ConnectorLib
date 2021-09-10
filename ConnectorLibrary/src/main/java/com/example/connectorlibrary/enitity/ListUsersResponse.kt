package com.example.connectorlibrary.enitity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ListUsersResponse(
    @ResponseCode val responseCode: Int,
    val listUsers: List<User>
) : Parcelable