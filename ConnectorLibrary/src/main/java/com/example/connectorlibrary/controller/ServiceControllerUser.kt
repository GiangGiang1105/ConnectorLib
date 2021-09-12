package com.example.connectorlibrary.controller

import android.content.Context
import android.util.Log
import com.example.connectorlibrary.base.CallbackProvider
import com.example.connectorlibrary.callback.CallbackConnector
import com.example.connectorlibrary.enitity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceControllerUser(context: Context) : CallbackConnector.CallbackConnectorUser,
    CallbackProvider<CallbackConnector.CallbackConnectorUser> {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private val serviceProvider = ServiceConnector.Builder(context)
        .setCallback(this)
        .build()
    override val callbacks: ArrayList<CallbackConnector.CallbackConnectorUser> = ArrayList()

    override fun addCallback(callbackConnector: CallbackConnector.CallbackConnectorUser) {
        super.addCallback(callbackConnector)
        Log.e("TAG", "addCallback: ")
        if (callbacks.size > 0) {
            connect()
        }
    }

    override fun removeCallback(callbackConnector: CallbackConnector.CallbackConnectorUser) {
        super.removeCallback(callbackConnector)
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
            Log.e("TAG", "onFailureResponse:controller ")
            callbacks.forEach {
                it.onFailureResponse(failureResponse)
            }
        }
    }

    override fun onUserSignUp(authResponse: AuthResponse) {
        coroutineScope.launch {
            Log.e("TAG", "onUserSignUp: controller")
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

    override fun onGetStatisticCovidVn(statisticCovidVnResponse: StatisticCovidVnResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetStatisticCovidVn(statisticCovidVnResponse)
            }
        }
    }

    override fun onGetStatisticCovidWorld(statisticCovidWorldResponse: StatisticCovidWorldResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetStatisticCovidWorld(statisticCovidWorldResponse)
            }
        }
    }

    override fun onGetHistoryCovidWorld(historyCovidResponse: HistoryCovidResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetHistoryCovidWorld(historyCovidResponse)
            }
        }
    }

    override fun onGetHistoryCovidVn(historyCovidResponse: HistoryCovidResponse) {
        coroutineScope.launch {
            callbacks.forEach {
                it.onGetHistoryCovidVn(historyCovidResponse)
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
        Log.e("TAG", "connect: ")
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
        Log.e("TAG", "userSignUp: 11111")
        serviceProvider.userSignUp(user)
    }

    fun userSignIn(phoneNumber: String) {
        serviceProvider.userSignIn(phoneNumber)
    }

    fun insertHealth(health: Health) {
        serviceProvider.insertHealth(health)
    }

    fun getStatisticCovidVn() {
        serviceProvider.getStatisticCovidVn()
    }

    fun getStatisticCovidWorld() {
        serviceProvider.getStatisticCovidWorld()
    }

    fun getHistoryCovidVn() {
        serviceProvider.getHistoryCovidVn()
    }

    fun getHistoryCovidWorld() {
        serviceProvider.getHistoryCovidWorld()
    }


    fun getUser(userId: Int) {
        serviceProvider.getUser(userId)
    }

    fun updateUser(user: User) {
        serviceProvider.updateUser(user)
    }
}