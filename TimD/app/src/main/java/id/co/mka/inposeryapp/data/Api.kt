package id.co.mka.inposeryapp.data

import id.co.mka.inposeryapp.login.data.LoginResponse
import id.co.mka.inposeryapp.register.data.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("api/v1/auth/register")
    fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phone") phone: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("api/v1/auth/login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<LoginResponse>
}