package com.example.connectorlibrary.callback

import com.example.connectorlibrary.enitity.*

interface Callback {

    fun onServerConnected()

    fun onGetStatus(statusResponse: StatusResponse)

    fun onGetSymptom(symptomResponse: SymptomResponse)

    fun onGetActive(activeResponse: ActiveResponse)

    fun onGetGender(genderResponse: GenderResponse)

    fun onGetUserHealths(healthResponse: HealthResponse)

    fun onFailureResponse(failureResponse: FailureResponse)

    interface CallbackUser : Callback {

        fun onUserSignUp(authResponse: AuthResponse)

        fun onUserSignIn(authResponse: AuthResponse)

        fun onInsertHealth(healthResponse: HealthResponse)

        fun onGetStatisticCovid(statisticCovidResponse: StatisticCovidResponse)

        fun onGetUser(user: UserResponse)

        fun onUpdateUser(user: UserResponse)
    }

    interface CallbackAdmin: Callback {

        fun onGetAllUsers(listUsersResponse: ListUsersResponse)

        fun onDeleteUser(user: UserResponse)

        fun onLockUser(userResponse: UserResponse)
    }
}
