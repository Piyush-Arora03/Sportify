package com.example.contact_manager

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.contact_manager.R.layout.upcomingview
import com.example.contact_manager.upcomingviewtype

class uppcomingadapter(val fragcontext:Context,val itemslist:ArrayList<upcomingviewtype>)
:ArrayAdapter<upcomingviewtype>(fragcontext, upcomingview,itemslist){
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflate= LayoutInflater.from(context)
        val itemview=inflate.inflate(upcomingview,null)
        val team1= itemview.findViewById<ImageView>(R.id.team1image)
        val team2=itemview.findViewById<ImageView>(R.id.team2image)
        val datetime=itemview.findViewById<TextView>(R.id.time)
        val curritem=itemslist[position]
        team1.setImageResource(curritem.team1image)
        team2.setImageResource(curritem.team2image)
        datetime.text=curritem.datetime
        return itemview
    }
}