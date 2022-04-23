package com.avanade.loginretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.avanade.loginretrofit.api.Endpoint
import com.avanade.loginretrofit.model.User
import com.avanade.loginretrofit.util.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.LogManager

class MainActivity : AppCompatActivity() {
    private lateinit var etLogin : EditText
    private lateinit var etPassword : EditText
    private lateinit var bLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLogin = findViewById(R.id.etLogin)
        etPassword = findViewById(R.id.etPassword)
        bLogin = findViewById(R.id.bLogin)

        bLogin.setOnClickListener { login()}
    }

    fun login(){
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://authenticationmock.azure-api.net/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        val callback = endpoint.authenticate(etLogin.text.toString(), etPassword.text.toString())

        callback.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Toast.makeText(baseContext, "Name: ${response.body()?.name}", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("Erro ao realizar login")
            }

        })
    }
}