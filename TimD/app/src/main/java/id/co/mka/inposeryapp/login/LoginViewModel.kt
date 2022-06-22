package id.co.mka.inposeryapp.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.mka.inposeryapp.data.Api
import id.co.mka.inposeryapp.login.data.LoginResponse
import id.co.mka.inposeryapp.login.data.UserLogin
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessController.getContext


class LoginViewModel : ViewModel() {
    fun loginUser(
        apiService: Api,
        email: String,
        password: String

    ): LiveData<UserLogin> {
        val result = MutableLiveData<UserLogin>()
        try {
            val param = mutableMapOf<String, String>()
            param["email"] = email
            param["password"] = password


            //    apiService.registerUser(param).enqueue(object : Callback<RegisterResponse> {
            //        override fun onResponse(
            //          call: Call<RegisterResponse>,
            //        response: Response<RegisterResponse>
            apiService.loginUser(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>,
                    ) {
                        //       val responseResult = response.body()
                        //  ) {
                        if (response.isSuccessful) {
                            val responseResult = response.body()
                            Log.d("Response", response.body().toString())
                            result.value = UserLogin(
                                responseResult?.data?.token ?: "",
                                200,
                                responseResult?.message ?: "Sukes",
                            )

                        } else {
                            val responseResult = JSONObject(response.errorBody()!!.string())
                            result.value = UserLogin(
                                "",
                                responseResult.getInt("statusCode"),
                                responseResult.getString("message") ?: "Internal Server Error"
                            )
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.e("Login", "onFailure: ${t.message}", t)
                    }

                })
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("LOGIN", "Login Failed: ${e.message}", e)
        }

        return result
    }
}