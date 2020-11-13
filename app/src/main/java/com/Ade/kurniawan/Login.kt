package com.Ade.kurniawan

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.util.prefs.AbstractPreferences

class Login : AppCompatActivity() {
    val PREFS_NAME = "UTS MOBILE PROGRAMING"
    val KEY_EMAIL = "ade@mail.com"
    val KEY_PASSWORD ="ade"
    lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
    }

    private fun simpanEmail(email: String){
        val editor : SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    private fun simpanPass(password: String){
        val editor : SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
    }

    private fun msg(){
        val email: String = input_email.text.toString()
        val password : String= input_password.text.toString()
        when{
            email== "" -> {
                val msg:Toast= Toast.makeText(applicationContext, "masukan email", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0, 140)
                msg.show()
            }
            password== "" -> {
                val msg:Toast= Toast.makeText(applicationContext, "masukan password", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0, 140)
                msg.show()
            }
            else -> {
                val msg:Toast= Toast.makeText(applicationContext, "login berhasil", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0, 140)
                msg.show()
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
    }


    fun onLogin(view: View){
        val email: String = input_email.text.toString()
        simpanEmail(email)

        val password: String = input_email.text.toString()
        simpanPass(password)
        msg()
    }
}