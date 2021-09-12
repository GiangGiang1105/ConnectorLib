// IServerServiceCallback.aidl
package com.example.connectorlibrary.controller;

import com.example.connectorlibrary.enitity.AuthResponse;
import com.example.connectorlibrary.enitity.HealthResponse;
import  com.example.connectorlibrary.enitity.UserResponse;
import  com.example.connectorlibrary.enitity.ListUsersResponse;
import  com.example.connectorlibrary.enitity.StatusResponse;
import  com.example.connectorlibrary.enitity.StatisticCovidWorldResponse;
import  com.example.connectorlibrary.enitity.StatisticCovidVnResponse;
import  com.example.connectorlibrary.enitity.SymptomResponse;
import  com.example.connectorlibrary.enitity.ActiveResponse;
import  com.example.connectorlibrary.enitity.GenderResponse;
import  com.example.connectorlibrary.enitity.FailureResponse;
import  com.example.connectorlibrary.enitity.HistoryCovidResponse;
// Declare any non-default types here with import statements

interface  IServerServiceCallback {
/**
    * Called upon user signup request process.
    */
    void onUserSignUp(in AuthResponse authResponse);
/**
    * Called upon user signin request process.
    */
    void onUserSignIn(in AuthResponse authResponse);
/**
      * Called upon user health request process.
      */
    void onInsertHealth(in HealthResponse healthResponse);
/**
       * Called upon get user health request process.
     */
    void onGetUserHealths(in HealthResponse listHealths);
    /**
            * Called upon get user request process.
          */
    void onGetUser(in UserResponse userResponse);
    /**
             * Called upon get user request process.
           */
    void onGetAllUsers(in ListUsersResponse listUsersResponse);
     /**
               * Called upon update user request process.
             */
    void onUpdateUser(in UserResponse userResponse);

     /**
        * Called upon delete user request process.
    */
    void onDeleteUser(in UserResponse userResponse);
     /**
                   * Called upon update user request process.
                 */
    void onLockUser(in UserResponse userResponse);
    /**
          * Called upon get static request process.
       */
    void onGetStatus(in StatusResponse statusResponse);

     /**
              * Called upon get statistic covid vietnam request process.
         */
    void onGetStatisticCovidVn(in StatisticCovidVnResponse statistic);

       /**
                  * Called upon get statistic covid world request process.
             */
    void onGetStatisticCovidWorld(in StatisticCovidWorldResponse statistic);
     /**
                      * Called upon get history covid vietnam request process.
                 */
    void onGetHistoryCovidVn(in HistoryCovidResponse history);

     /**
                          * Called upon get history covid vietnam request process.
                     */
    void onGetHistoryCovidWorld(in HistoryCovidResponse history);

    /**
              * Called upon get symptom request process.
         */
    void onGetSymptom(in SymptomResponse symptomResponse);
     /**
               * Called upon get active request process.
          */
    void onGetActive(in ActiveResponse activeResponse);
     /**
                   * Called upon get gender request process.
              */
     void onGetGender(in GenderResponse genderResponse);
      /**
                        * Called upon sa request process if even error.
                   */

 /**
                   * Called upon all request process if even error.
              */
     void onFailureResponse(in FailureResponse failureResponse);
}
