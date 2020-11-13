package com.Ade.kurniawan

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "UTS MOBILE PROGRAMING"
    val KEY_EMAIL = "ade@mail.com"
    val KEY_PASSWORD ="ade"
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crd_news.setOnClickListener {
        //berpindah activity Intent(activity-saat-ini, activity-tujuan)
            val pindah = Intent(this@MainActivity, News::class.java)
            //menjalankan intent
            startActivity(pindah)
        }

        crd_calculator.setOnClickListener {
            val pindah = Intent(this@MainActivity, Calculator::class.java)
            startActivity(pindah)
        }

        crd_about.setOnClickListener {
            val pindah = Intent(this@MainActivity, About::class.java)
            startActivity(pindah)
        }

    }

    fun onLogout(view: View){
        hapusData()
        startActivity(Intent(this, Login::class.java))
    }

    private fun hapusData(){
        val editor : SharedPreferences.Editor= sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    private fun getEmail():String? = sharedPref.getString(KEY_EMAIL, null)
    private fun getPassword():String? = sharedPref.getString(KEY_PASSWORD, null)
}