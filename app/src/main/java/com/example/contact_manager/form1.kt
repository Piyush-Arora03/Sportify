package com.example.contact_manager

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class form1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spineer=findViewById<Spinner>(R.id.spinner)

        val items= arrayOf("Select sport","Football","Cricket","Vollyball","Badminton","Table Tennis")
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        spineer.adapter=adapter
        spineer.setSelection(0)

        val spinner2=findViewById<Spinner>(R.id.spinner2)
        val items2= arrayOf("Select Role","Referee","Umpire","Commentator")
        val adapter2= ArrayAdapter(this,android.R.layout.simple_list_item_1,items2)
        spinner2.adapter=adapter2
        spinner2.setSelection(0)


        val button=findViewById<AppCompatButton>(R.id.apply)
        val name=findViewById<EditText>(R.id.name)
        val collegeid=findViewById<EditText>(R.id.collegeid)
        val uniqueid=findViewById<EditText>(R.id.id)
        val pass=findViewById<EditText>(R.id.password)
        button.setOnClickListener(){
            val nameText = name.text.toString()
            val collegeidText = collegeid.text.toString()
            val uniqueidText = uniqueid.text.toString()
            val passText = pass.text.toString()
            if(nameText.isNotEmpty() && collegeidText.isNotEmpty() && uniqueidText.isNotEmpty()  && passText.isNotEmpty()  && spinner2.selectedItemPosition!=0 && spineer.selectedItemPosition!=0 ){

                Toast.makeText(this,"Application Submitted", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,navview::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Fill The Require Field First", Toast.LENGTH_SHORT).show()
            }

        }
    }
}