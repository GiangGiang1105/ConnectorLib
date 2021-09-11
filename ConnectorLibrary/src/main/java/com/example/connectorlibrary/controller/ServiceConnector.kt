package com.example.connectorlibrary.controller

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import com.example.connectorlibrary.R
import com.example.connectorlibrary.callback.CallbackConnector
import com.example.connectorlibrary.enitity.*

class ServiceConnector(private val context: Context) {

    var serviceConnected = false
    private var serverService: IServerService? = null
    var callbackConnector: CallbackConnector? = null
    var callbackConnectorAdmin: CallbackConnector.CallbackConnectorAdmin? = null
    var callbackConnectorUser: CallbackConnector.CallbackConnectorUser? = null


    private val serviceConnection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG, "onServiceConnected")
            serviceConnected = true
            serverService = IServerService.Stub.asInterface(service)
            try {
                serverService?.registerCallback(serverServiceCallback)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
            callbackConnector?.onServerConnected()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected")
            serverService = null
            serviceConnected = false
        }

    }

    private val serverServiceCallback = object : IServerServiceCallback.Stub() {

        override fun onUserSignUp(authResponse: AuthResponse) {
            callbackConnectorUser?.onUserSignUp(authResponse)
        }

        override fun onUserSignIn(authResponse: AuthResponse) {
            callbackConnectorUser?.onUserSignIn(authResponse)
        }

        override fun onInsertHealth(healthResponse: HealthResponse) {
            callbackConnectorUser?.onInsertHealth(healthResponse)
        }

        override fun onGetUserHealths(listHealths: HealthResponse) {
            callbackConnector?.onGetUserHealths(listHealths)
        }

        override fun onGetUser(userResponse: UserResponse) {
            callbackConnectorUser?.onGetUser(userResponse)
        }

        override fun onGetAllUsers(listUsersResponse: ListUsersResponse) {
            callbackConnectorAdmin?.onGetAllUsers(listUsersResponse)
        }

        override fun onUpdateUser(userResponse: UserResponse) {
            callbackConnectorUser?.onUpdateUser(userResponse)
        }

        override fun onDeleteUser(userResponse: UserResponse) {
            callbackConnectorAdmin?.onDeleteUser(userResponse)
        }

        override fun onLockUser(userResponse: UserResponse) {
            callbackConnectorAdmin?.onLockUser(userResponse)
        }

        override fun onGetStatus(statusResponse: StatusResponse) {
            callbackConnector?.onGetStatus(statusResponse)
        }

        override fun onGetStatisticCovid(statistic: StatisticCovidResponse) {
            callbackConnectorUser?.onGetStatisticCovid(statistic)
        }

        override fun onGetSymptom(symptomResponse: SymptomResponse) {
            callbackConnector?.onGetSymptom(symptomResponse)
        }

        override fun onGetActive(activeResponse: ActiveResponse) {
            callbackConnector?.onGetActive(activeResponse)
        }

        override fun onGetGender(genderResponse: GenderResponse) {
            callbackConnector?.onGetGender(genderResponse)
        }

        override fun onFailureResponse(failureResponse: FailureResponse) {
            callbackConnector?.onFailureResponse(failureResponse)
        }

    }

    fun connectService() {
        Log.e(TAG, "connectService: ", )
        if (serviceConnected) {
            Log.d(TAG, "connectService: service was already connected. Ignoring...")
            return
        }
        val intent = Intent()
        intent.apply {
            component =
                ComponentName.unflattenFromString(context.getString(R.string.component_server_service))
            action = context.getString(R.string.action_server_service)
        }
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    fun disconnectService() {
        if (!serviceConnected) {
            Log.d(TAG, "disconnectService:  service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.unregisterCallback(serverServiceCallback)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        context.unbindService(serviceConnection)
        serviceConnected = false
    }

    fun getStatus() {
        if (!serviceConnected) {
            Log.d(TAG, "getStatus: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getStatus()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getSymptom() {
        if (!serviceConnected) {
            Log.d(TAG, "getSymptom: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getStatus()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getActive() {
        if (!serviceConnected) {
            Log.d(TAG, "getActive: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getActive()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getGender() {
        if (!serviceConnected) {
            Log.d(TAG, "getGender: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getStatus()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getUserHealths() {
        if (!serviceConnected) {
            Log.d(TAG, "getUserHealths: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getUserHealths()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getAllUsers() {
        if (!serviceConnected) {
            Log.d(TAG, "getAllUsers: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getAllUsers()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun deleteUser(user: User) {
        if (!serviceConnected) {
            Log.d(TAG, "getAllUsers: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.deleteUser(user)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun lockUser(user: User) {
        if (!serviceConnected) {
            Log.d(TAG, "lockUser: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.lockUser(user)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun userSignUp(user: User) {
        Log.e(TAG, "userSignUp:serr ", )
        if (!serviceConnected) {
            Log.d(TAG, "userSignUp: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.userSignUp(user)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun userSignIn(phoneNumber: String) {
        if (!serviceConnected) {
            Log.d(TAG, "userSignIn: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.userSignIn(phoneNumber)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun insertHealth(health: Health) {
        if (!serviceConnected) {
            Log.d(TAG, "insertHealth: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.insertHealth(health)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getStatisticCovid() {
        if (!serviceConnected) {
            Log.d(TAG, "getStatisticCovid: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getStatisticCovid()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun getUser(userId: Int) {
        if (!serviceConnected) {
            Log.d(TAG, "getUser: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.getUser(userId)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun updateUser(user: User) {
        if (!serviceConnected) {
            Log.d(TAG, "updateUser: service is not connected. Ignoring...")
            return
        }
        try {
            serverService?.updateUser(user)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    class Builder(context: Context) {

        private val connectorClient = ServiceConnector(context)

        fun setCallback(cb: CallbackConnector): Builder {
            connectorClient.callbackConnector = cb
            if (cb is CallbackConnector.CallbackConnectorUser) connectorClient.callbackConnectorUser = cb
            if (cb is CallbackConnector.CallbackConnectorAdmin) connectorClient.callbackConnectorAdmin = cb
            return this@Builder
        }

        fun build(): ServiceConnector = connectorClient
    }

    companion object {
        val TAG: String = ServiceConnector::class.java.name
    }
}


