package com.example.connectorlibrary.controller

import android.content.Context
import com.example.connectorlibrary.base.CallbackProvider
import com.example.connectorlibrary.callback.Callback
import com.example.connectorlibrary.enitity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceControllerUser(context: Context) : Callback.CallbackUser,
    CallbackProvider<Callback.CallbackUser> {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private val serviceProvider = ServiceConnector.Builder(context)
        .setCallback(this)
        .build()
    override val callbacks: ArrayList<Callback.CallbackUser> = ArrayList()

    override fun addCallback(callback: Callback.CallbackUser) {
        if (callbacks.size > 0) {
            connect()
        }
    }

    override fun removeCallback(callback: Callback.CallbackUser) {
        super.removeCallback(callback)
        if (callbacks.size == 0) {
            disconnect()
        }
    }


    override fun onServerConnected() {
        coroutineScope.launch {
            callbacks.forEach {
                it.onServerConnected()
            }
        }
    }

    override fun onGetStatus(statusResponse: StatusResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetStatus(statusResponse)
            }
        }
    }

    override fun onGetSymptom(symptomResponse: SymptomResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetSymptom(symptomResponse)
            }
        }
    }

    override fun onGetActive(activeResponse: ActiveResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetActive(activeResponse)
            }
        }
    }

    override fun onGetGender(genderResponse: GenderResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetGender(genderResponse)
            }
        }
    }

    override fun onGetUserHealths(healthResponse: HealthResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetUserHealths(healthResponse)
            }
        }
    }

    override fun onFailureResponse(failureResponse: FailureResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onFailureResponse(failureResponse)
            }
        }
    }

    override fun onUserSignUp(authResponse: AuthResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onUserSignUp(authResponse)
            }
        }
    }

    override fun onUserSignIn(authResponse: AuthResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onUserSignIn(authResponse)
            }
        }
    }

    override fun onInsertHealth(healthResponse: HealthResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onInsertHealth(healthResponse)
            }
        }
    }

    override fun onGetStatisticCovid(statisticCovidResponse: StatisticCovidResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetStatisticCovid(statisticCovidResponse)
            }
        }
    }

    override fun onGetUser(user: UserResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetUser(user)
            }
        }
    }

    override fun onUpdateUser(user: UserResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onUpdateUser(user)
            }
        }
    }

    private fun connect() {
        serviceProvider.connectService()
    }

    private fun disconnect() {
        serviceProvider.disconnectService()
    }

    fun getStatus() {
        serviceProvider.getStatus()
    }

    fun getSymptom() {
        serviceProvider.getSymptom()
    }

    fun getActive() {
        serviceProvider.getActive()
    }

    fun getGender() {
        serviceProvider.getGender()
    }

    fun getUserHealths() {
        serviceProvider.getUserHealths()
    }

    fun userSignUp(user: User) {
        serviceProvider.userSignUp(user)
    }

    fun userSignIn(phoneNumber: String) {
        serviceProvider.userSignIn(phoneNumber)
    }

    fun insertHealth(health: Health) {
        serviceProvider.insertHealth(health)
    }

    fun getStatisticCovid() {
        serviceProvider.getStatisticCovid()
    }

    fun getUser(userId: Int) {
        serviceProvider.getUser(userId)
    }

    fun updateUser(user: User) {
        serviceProvider.updateUser(user)
    }
}