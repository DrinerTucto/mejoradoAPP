    package com.example.login14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

    class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var auth: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email =findViewById<TextView>(R.id.email)
        val password =findViewById<TextView>(R.id.pass)
        val btn = findViewById<Button>(R.id.button)
        val texbtn=findViewById<TextView>(R.id.textView3)
firebaseAuth=Firebase.auth
        btn.setOnClickListener {
            login(email.text.toString(),password.text.toString())
        }
        texbtn.setOnClickListener {
            val bulder=AlertDialog.Builder(this@MainActivity)
            val view=layoutInflater.inflate(R.layout.activity_main3,null)
            bulder.setView(view)
            val registro= bulder.create()
            registro.show()
         }

    }



        private fun login(email:String,pasword:String){

        firebaseAuth.signInWithEmailAndPassword(email,pasword)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    val user = firebaseAuth.currentUser
                     Toast.makeText(baseContext,"bienvenido ",Toast.LENGTH_SHORT).show()
                    val name = Intent(this,MainActivity2::class.java)
                    val d = startActivity(name)

                }else{
                    Toast.makeText(baseContext,"ERROR ",Toast.LENGTH_SHORT).show()
                }
            }

    }
}