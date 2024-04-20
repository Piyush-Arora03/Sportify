package com.example.contact_manager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class upcomingfrag : Fragment() {
    lateinit var items:ArrayList<upcomingviewtype>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview= inflater.inflate(R.layout.fragment_upcomingfrag, container, false)
        val team1image= arrayOf(R.drawable.csk,R.drawable.mi)
        val team2image= arrayOf(R.drawable.csk,R.drawable.mi)
        val listview=rootview.findViewById<ListView>(R.id.upcominglist)
        val datetime  = arrayOf("16:00\n27/04/24","16:30\n29/12/24")
        items= arrayListOf<upcomingviewtype>()
        for(i in datetime.indices){
            val user=upcomingviewtype(team1image[i],team2image[i],datetime[i])
            items.add(user)
        }
       val upcoingadapter=uppcomingadapter(requireContext(), items)
       listview.adapter=upcoingadapter


        return rootview
    }

    companion object {

    }
}