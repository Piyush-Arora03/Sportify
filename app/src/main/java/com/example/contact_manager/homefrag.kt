package com.example.contact_manager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class homefrag : Fragment() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview= inflater.inflate(R.layout.fragment_homefrag, container, false)
        database=FirebaseDatabase.getInstance().getReference("liveteam")
        val teamscore1=rootview.findViewById<TextView>(R.id.teamscore)
        val teamscore2=rootview.findViewById<TextView>(R.id.teamscore2)
database.addValueEventListener(object : ValueEventListener{
    override fun onDataChange(snapshot: DataSnapshot) {
        database.get().addOnSuccessListener {
            teamscore1.text="${it.child("team1").child("teamname").child("str").value.toString()}\n${it.child("team1").child("run").value.toString()}-${it.child("team1").child("wicket").value.toString()} (${it.child("over").child("integer").value.toString()}.${it.child("over").child("decimal").value.toString()})"
            teamscore2.text="${it.child("team2").child("teamname").child("str").value.toString()}\n0-0(0.0)"



        }
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }

})


        replacewithfrag(livefrag())
        val button=rootview.findViewById<AppCompatButton>(R.id.upcoming)
        val button2=rootview.findViewById<AppCompatButton>(R.id.live)
        val button3=rootview.findViewById<AppCompatButton>(R.id.past)
        button2.setBackgroundDrawable(resources.getDrawable(R.drawable.clickedbutton))
        button.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
        button3.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
        button.setOnClickListener(){
            replacewithfrag(upcomingfrag())
            button.setBackgroundDrawable(resources.getDrawable(R.drawable.clickedbutton))
            button2.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
            button3.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
        }
        button2.setOnClickListener(){
            replacewithfrag(livefrag())
            button2.setBackgroundDrawable(resources.getDrawable(R.drawable.clickedbutton))
            button.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
            button3.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
        }
        button3.setOnClickListener(){
            replacewithfrag(pastfrag())
            button3.setBackgroundDrawable(resources.getDrawable(R.drawable.clickedbutton))
            button2.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
            button.setBackgroundDrawable(resources.getDrawable(R.drawable.notclicked))
        }


        return rootview
    }

    companion object {

    }
    fun replacewithfrag(fragment : Fragment){
        val man=childFragmentManager
        val transction=man.beginTransaction()
        transction.replace(R.id.liveframe,fragment)
        transction.commit()
    }
}