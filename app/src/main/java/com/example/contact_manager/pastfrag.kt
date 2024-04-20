package com.example.contact_manager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class pastfrag : Fragment() {
lateinit var items:ArrayList<pastitemtype>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview= inflater.inflate(R.layout.fragment_pastfrag, container, false)
        val date= arrayOf("01/04/24","29/03/24")
        val wonteamimage = arrayOf(R.drawable.csk,R.drawable.csk)
        val wonteamname = arrayOf("Chennai Super Kings","Bindass Bhide")
        val wonteamrun= arrayOf("123/5","123/5")
        val wonteamover= arrayOf("(20.0)","(20.0)")
        val lossteamimage= arrayOf(R.drawable.mi,R.drawable.mi)
        val lossteamname= arrayOf("Mumbai Indians","Jabardast Jetha")
        val lossteamrun= arrayOf("117/7","117/7")
        val lossteamover= arrayOf("(20.0)","(20.0)")
        val teamwonby= arrayOf("CSK Won By 6 Runs","BB Won By 6 Runs")

        val recyclerview=rootview.findViewById<RecyclerView>(R.id.pastrecycler)
        recyclerview.layoutManager=LinearLayoutManager(requireContext())
         items= arrayListOf<pastitemtype>()
        for(i in date.indices){
            val user=pastitemtype(date[i],wonteamimage[i],wonteamname[i],wonteamrun[i],wonteamover[i],lossteamimage[i],lossteamname[i],lossteamrun[i],lossteamover[i],teamwonby[i])
            items.add(user)
        }
        recyclerview.adapter=pastadapter(items,this)
        return rootview
    }

    companion object {

    }
}