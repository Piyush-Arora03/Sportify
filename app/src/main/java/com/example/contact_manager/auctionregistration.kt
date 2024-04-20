package com.example.contact_manager

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import java.util.UUID
import android.Manifest
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.properties.Delegates

class auctionregistration : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var database:DatabaseReference
    lateinit var selectedsport: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auctionregistration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database=FirebaseDatabase.getInstance().getReference("auction")
        val spineer=findViewById<Spinner>(R.id.spinner)
        val name=findViewById<EditText>(R.id.name)
        val baseprice=findViewById<EditText>(R.id.baseprice)
        val button=findViewById<AppCompatButton>(R.id.register)



        val items= arrayOf("Select sport","Football","Cricket","Vollyball","Badminton")
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        spineer.adapter=adapter
        spineer.setSelection(0)

        button.setOnClickListener(){
            spineer.onItemSelectedListener=this
            val nameText = name.text.toString()
            val baseText = baseprice.text.toString().toInt()
        if(nameText.isNotEmpty()  && spineer.selectedItemPosition!=0){
            if(baseText>=0 && baseText<=10){
                database.setValue(nameText).addOnSuccessListener {
                    database.child(nameText).child("baseprice").setValue(baseText)
                    Toast.makeText(this, "Data stored successfully", Toast.LENGTH_SHORT).show()
                }

            }
            else{
                Toast.makeText(this,"base price must range 0 to 10",Toast.LENGTH_SHORT).show()
            }
        }
            else{
                Toast.makeText(this,"bchbvhabdvhbdjvbsv",Toast.LENGTH_SHORT).show()
        }

    }

   }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedsport=parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,"njdv",Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}