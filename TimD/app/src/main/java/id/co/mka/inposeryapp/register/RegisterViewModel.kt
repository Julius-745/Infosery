package id.co.mka.inposeryapp.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.mka.inposeryapp.data.Api
import id.co.mka.inposeryapp.register.data.RegisterResponse
import id.co.mka.inposeryapp.register.data.UserRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    fun registerUser(
        apiService: Api,
        name: String,
        email: String,
        phone: String,
        password: String


    ): LiveData<UserRegister> {
        val result = MutableLiveData<UserRegister>()
        try {
            val param = mutableMapOf<String, String>()
            param["name"] = name
            param["email"] = email
            param["password"] = password
            param["phone"] = phone


            //    apiService.registerUser(param).enqueue(object : Callback<RegisterResponse> {
            //        override fun onResponse(
            //          call: Call<RegisterResponse>,
            //        response: Response<RegisterResponse>
            apiService.registerUser(email, name, phone, password)
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {
                        //       val responseResult = response.body()
                        //  ) {
                        if (response.isSuccessful) {
                            val responseResult = response.body()

                            result.value = UserRegister(
                                responseResult?.message ?: "",
                                responseResult?.data?.name ?: "",
                            )

                        } else {
                            result.value = UserRegister(
                                "",
                                "",
                            )
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Log.e("Register", "onFailure: ${t.message}", t)
                    }

                })
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("REGISTER", "Register Failed: ${e.message}", e)
        }

        return result
    }
}