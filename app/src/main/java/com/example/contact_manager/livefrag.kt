package com.example.contact_manager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class livefrag : Fragment() {


lateinit var database : DatabaseReference
lateinit var database2 :DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview= inflater.inflate(R.layout.fragment_livefrag, container, false)
        val p1=rootview.findViewById<TextView>(R.id.player1)
        val p2=rootview.findViewById<TextView>(R.id.player2)
        val  bowler=rootview.findViewById<TextView>(R.id.bowler)
        database=FirebaseDatabase.getInstance().getReference("bat1")
        database2=FirebaseDatabase.getInstance().getReference("bowl1").child("p1")
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                database.child("p1").get().addOnSuccessListener {
                    p1.text="${it.child("name").value.toString()}                                    ${it.child("run").value.toString()}          ${it.child("bowl").value.toString()}            ${it.child("s4").value.toString()}            ${it.child("s6").value.toString()}"
                }
                database.child("p2").get().addOnSuccessListener {
                    p2.text="${it.child("name").value.toString()}                                    ${it.child("run").value.toString()}          ${it.child("bowl").value.toString()}            ${it.child("s4").value.toString()}            ${it.child("s6").value.toString()}"
                }
                database2.get().addOnSuccessListener {
                    bowler.text="${it.child("name").value.toString()}                               ${it.child("over").value.toString()}          ${it.child("run").value.toString()}            ${it.child("wicket").value.toString()}"
                }

                val live=rootview.findViewById<TextView>(R.id.livematch)
                live.setOnClickListener(){
                    val intent= Intent(requireContext(),liveview::class.java)
                    startActivity(intent)
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


        return rootview
    }

    companion object {

    }
}