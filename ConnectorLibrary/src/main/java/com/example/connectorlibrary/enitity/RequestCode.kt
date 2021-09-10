package com.example.connectorlibrary.enitity

@Suppress("UNUSED")
@Retention(AnnotationRetention.SOURCE)
annotation class RequestCode {
    companion object {
        const val SIGN_UP_REQ = 1
        const val SIGN_IN_REQ = 2
        const val GET_USER = 3
        const val UPDATE_USER = 4
        const val GET_LIST_USERS = 5
        const val INSERT_HEALTH = 6
        const val GET_HEALTHS = 7
        const val GET_SYMPTOMS = 8
        const val GET_STATISTIC_COVID = 9
        const val GET_STATICS = 10
    }
}