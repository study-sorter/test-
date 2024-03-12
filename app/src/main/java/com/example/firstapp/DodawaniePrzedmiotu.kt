package com.example.firstapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.log


class DodawaniePrzedmiotu : AppCompatActivity() {
    private val chmura = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodawanie_przedmiotu)
        var button : Button= findViewById(R.id.submit_przedmiot)
        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var key = chmura.hashCode()

            }
        })
        var logout : Button= findViewById(R.id.logout)
        logout.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                FirebaseAuth.getInstance().signOut()

                intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        })
/*
        var wys : Button= findViewById(R.id.wys)
        wys.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                intent = Intent(applicationContext, WyswietleniePrzedmiotow::class.java)
                startActivity(intent)
            }
        })


 */



    }
}