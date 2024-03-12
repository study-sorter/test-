package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Rejestracja : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rejestracja)
        var button:Button = findViewById(R.id.button)
        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val pole_mail : EditText = findViewById(R.id.editTextTextEmailAddress)
                var pole_haslo : EditText = findViewById(R.id.editTextTextPassword)
                var mail : String = pole_mail.text.toString()
                var haslo : String = pole_haslo.text.toString()
                if(mail.isNotEmpty() && haslo.isNotEmpty()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,haslo).addOnCompleteListener{
                        if(it.isSuccessful){
                            intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@Rejestracja,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }



                }
            }
        })
    }
}