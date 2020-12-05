package com.globalnews.viewmodels

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.globalnews.models.LoginResponse
import com.globalnews.repo.ApiClient
import com.globalnews.utils.AuthListeners
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewmodel : ViewModel() {

     var username:String = ""
     var password:String = ""

    lateinit  var authListeners : AuthListeners

    fun onLoginButtonClick(view: View)
    {
        if(username.isNullOrEmpty() || password.isNullOrEmpty())
        {
            authListeners.showtoast("it is empty")
        }
        else
        {
            apihit(username, password)
            authListeners.showtoast("it is filled")
        }
    }
    
    private fun apihit(name: String, pass: String)
    {
        val call: Call<LoginResponse>? = ApiClient.getClient.userlogin(name, pass)
        call!!.enqueue(object : Callback<LoginResponse?> {
            @RequiresApi(api = Build.VERSION_CODES.O)
            override fun onResponse(call: Call<LoginResponse?>, response: Response<LoginResponse?>) {

                if (response.isSuccessful()) {

                    authListeners.showtoast("success")
//                    var dataget = response.body()?.jsondata?.let { ApiResponse(it) }
//                    binding?.data = response.body()?.jsondata?.let { ApiResponse(it) }

//                    if (dataget != null) {
//                        Toast.makeText(this@MainActivity, "data received" + dataget.jsondata!![0]?.name.toString(), Toast.LENGTH_SHORT).show()
//                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                call.cancel()
            }
        })
    }
}