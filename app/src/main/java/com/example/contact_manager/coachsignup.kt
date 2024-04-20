package com.example.contact_manager

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class coachsignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coachsignup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Dialog=Dialog(this)
        Dialog.setContentView(R.layout.dialogbox)
        val login=findViewById<TextView>(R.id.signin)
        login.setOnClickListener(){
            val intent= Intent(this,signin::class.java)
            startActivity(intent)
        }
        val button=findViewById<AppCompatButton>(R.id.verify)
        button.setOnClickListener(){
            Handler(Looper.getMainLooper()).postDelayed({
                Dialog.show()
                  Handler(Looper.getMainLooper()).postDelayed({
                      finish()
                  },5000)
            },0)

        }

    }
}