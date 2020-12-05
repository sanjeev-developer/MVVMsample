package com.globalnews.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.globalnews.R
import com.globalnews.databinding.ActivityLoginBinding
import com.globalnews.utils.AuthListeners
import com.globalnews.utils.toast
import com.globalnews.viewmodels.LoginViewmodel


class LoginActivity : AppCompatActivity() , AuthListeners {


   lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        binding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        val vobj = ViewModelProvider(this@LoginActivity).get(LoginViewmodel::class.java)
        binding.data = vobj

        vobj.authListeners =this@LoginActivity
    }

    override fun showtoast(message: String) {
        toast(message)
    }
}