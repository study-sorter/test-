package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun przeslij(view: View) {
        val Pole_imie : EditText = findViewById(R.id.Name)
        var Pole_nazwisko : EditText = findViewById(R.id.surname)
        var imie : String = Pole_imie.text.toString()
        var nazwisko : String = Pole_nazwisko.text.toString()
        val myRef = Firebase.database.getReference(imie + ' '+ nazwisko)
        val user = User( imie ,nazwisko)
        myRef.setValue(user)
    }

}