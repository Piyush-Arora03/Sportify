package com.example.contact_manager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class User2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val player=findViewById<Button>(R.id.player)
        val coach=findViewById<Button>(R.id.coach)

        player.setOnClickListener(){
            val intent= Intent(this,singup::class.java)
            startActivity(intent)
        }
        coach.setOnClickListener(){
            val intent= Intent(this,coachsignup::class.java)
            startActivity(intent)
        }
    }
}