package com.example.contact_manager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contact_manager.databinding.SingupBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class singup : AppCompatActivity() {
    lateinit var database:DatabaseReference
    lateinit var binding: SingupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=SingupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database=FirebaseDatabase.getInstance().getReference("user")


      //   val userdata=user(binding.name.text.toString(),binding.mail.text.toString(),binding.password.text.toString())



        binding.signup.setOnClickListener(){
            if(binding.checkBox.isChecked){

            val name = binding.name.text.toString()
            val mail = binding.mail.text.toString()
            val password = binding.password.text.toString()
            val id = binding.id.text.toString()

                val englishAlphabetPattern = "^[a-zA-Z]+$"
                val numberPattern = ".*\\d.*"
                val specialCharacterPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
                val gmail_com="^[a-zA-Z0-9._%+-]+@iiitranchi.ac.in$"

                // Check if the password meets the requirements
                val isPasswordValid =
                        password.matches(Regex(specialCharacterPattern))

                val isnamevalid=name.matches(Regex(englishAlphabetPattern))
                val ismailvalid=mail.matches(Regex(gmail_com))
                val isidvalid=id.matches(Regex("^[a-zA-Z0-9]+$"))

                if(name.isEmpty() || mail.isEmpty() || id.isEmpty()){
                    Toast.makeText(this,"Fields are empty Please fill it first",Toast.LENGTH_LONG).show()
                }
                else{
                if(!isPasswordValid){
                    Toast.makeText(this,"password must contain at least one digit , special character and english alphabet",Toast.LENGTH_LONG).show()
                }

                else if(!isnamevalid){
                    Toast.makeText(this,"name only contain english alphabet",Toast.LENGTH_LONG).show()
                }
                else if(!isidvalid){
                    Toast.makeText(this,"id must contain at least one digit  and english alphabet",Toast.LENGTH_LONG).show()
                }
                else if(!ismailvalid){
                    Toast.makeText(this,"enter correct college id",Toast.LENGTH_LONG).show()
                }
                else{
                    val userdata = user(name, mail, password)

                    database.child(binding.id.text.toString()).get().addOnSuccessListener {
                        if (it.exists()) {
                            Toast.makeText(
                                this,
                                "User already exist please enter a different unique id",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            database.child(binding.id.text.toString()).setValue(userdata)
                                .addOnSuccessListener {
                                    Toast.makeText(
                                        this,
                                        "User registered successfully",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                        }
                    }


                }
            }}
            else{
                Toast.makeText(this,"please accept our terms and conditions first",Toast.LENGTH_SHORT).show()
            }

        }

binding.signin.setOnClickListener(){
    val intent=Intent(this,signin::class.java)
    startActivity(intent)
}


    }
}