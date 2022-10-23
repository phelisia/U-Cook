package dev.phelisia.ucook.repository

import dev.phelisia.ucook.api.ApiClient
import dev.phelisia.ucook.api.ApiInterface
import dev.phelisia.ucook.models.LoginRequest
import dev.phelisia.ucook.models.ProfileRequest
import dev.phelisia.ucook.models.RegisterRequests
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



    class UserRepository {
        val apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
        suspend fun loginUser(loginRequest: LoginRequest)= withContext(Dispatchers.IO){
            val response=apiClient.login(loginRequest)
            return@withContext response
        }


        suspend fun registerUser(registerRequests: RegisterRequests)= withContext(Dispatchers.IO){
            val response=apiClient.registerUser(registerRequests)
            return@withContext response
        }

        suspend fun profileUser(profileRequest: ProfileRequest)= withContext(Dispatchers.IO){
            val response=apiClient.profile(profileRequest)
            return@withContext response
        }
    }
