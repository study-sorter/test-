package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private val Authenticator : FirebaseAuth = FirebaseAuth.getInstance()
    private val LOG_DEBUG = "LOG_DEBUG"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        isCurentUser()
    }
    private fun isCurentUser(){
        Authenticator.currentUser?.let{auth-> //jeśli null to się nie wykona
            intent = Intent(this, DodawaniePrzedmiotu::class.java).apply {
                flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)//wyczyszczenie tej aktywności czyli że nie można się tu cofnąć

            }
            startActivity(intent)

        }
    }


    fun zarejestruj(view: View){
        intent = Intent(this, Rejestracja::class.java)
        startActivity(intent)
    }

    fun zaloguj(view: View) {

        val pole_mail : EditText = findViewById(R.id.mail)
        var pole_haslo : EditText = findViewById(R.id.haslo)
        var mail : String = pole_mail.text.toString()
        var haslo : String = pole_haslo.text.toString()
        if(mail.isNotEmpty() && haslo.isNotEmpty()){


            Authenticator.signInWithEmailAndPassword(mail,haslo).addOnSuccessListener {
                intent = Intent(this, DodawaniePrzedmiotu::class.java).apply {
                    flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)//wyczyszczenie tej aktywności czyli że nie można się tu cofnąć
                }
                startActivity(intent)
            }.addOnFailureListener { exc ->
                Log.d(LOG_DEBUG,exc.message.toString())
            }
        }

    }
}