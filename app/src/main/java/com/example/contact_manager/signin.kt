package com.example.contact_manager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contact_manager.databinding.ActivitySigninBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signin : AppCompatActivity() {
     var x=0
    lateinit var database:DatabaseReference
    lateinit var binding1:ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding1=ActivitySigninBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding1.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database=FirebaseDatabase.getInstance().getReference("user")
       binding1.signin2.setOnClickListener(){
           database.child(binding1.uniqueid2.text.toString()).get().addOnSuccessListener {
               if(it.exists()){
                   val pass3: String=it.child("pass").value.toString()

                   if(binding1.pass2.text.toString()==pass3 || x==1){
                       Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
                       val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                       val editor = sharedPreferences.edit()
                       editor.putBoolean("isLoggedIn", true)
                       editor.apply()
                       val intent=Intent(this,sportsN::class.java)
                       startActivity(intent)
                   }
                   else{
                       Toast.makeText(this," Password is wrong ",Toast.LENGTH_SHORT).show()
                   }
               }
               else{
                   Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
               }
           }
       }

    }
}