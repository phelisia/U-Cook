package dev.phelisia.ucook.api

import dev.phelisia.ucook.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequests): Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/profile")
    suspend fun profile(@Body profileRequest: ProfileRequest): Response<ProfileResponse>


}