package com.example.contact_manager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Myadapter
import com.example.recyclerview.sport

class sportsN : AppCompatActivity() {
    lateinit var myrecyclerview:RecyclerView
    lateinit var itemlist:ArrayList<sport>
    lateinit var myAdapter:Myadapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sports_n)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val cricket=findViewById<CardView>(R.id.cricket)
        cricket.setOnClickListener(){
            val intent=Intent(this,navview::class.java)
            startActivity(intent)
        }
    }
}