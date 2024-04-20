package com.example.contact_manager

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class pastadapter(val itemslist:ArrayList<pastitemtype>,val context:Fragment) :
RecyclerView.Adapter<pastadapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         val date=itemView.findViewById<TextView>(R.id.date)
        val wonimage=itemView.findViewById<ImageView>(R.id.wonimage)
        val wonname=itemView.findViewById<TextView>(R.id.wonname)
        val wonrun=itemView.findViewById<TextView>(R.id.wonrun)
        val wonover=itemView.findViewById<TextView>(R.id.wonover)
        val lossimage=itemView.findViewById<ImageView>(R.id.lossimage)
        val lossname=itemView.findViewById<TextView>(R.id.lossname)
        val lossrun=itemView.findViewById<TextView>(R.id.lossrun)
        val lossover=itemView.findViewById<TextView>(R.id.lossover)
        val wonby=itemView.findViewById<TextView>(R.id.teamwonby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pastadapter.MyViewHolder {
        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.pastview,parent,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: pastadapter.MyViewHolder, position: Int) {
        val curritem=itemslist[position]
        holder.date.text=curritem.date
        holder.wonimage.setImageResource(curritem.wonteamimage)
        holder.wonname.text=curritem.wonteamname
        holder.wonrun.text=curritem.wonteamrun
        holder.wonover.text=curritem.wonteamover
        holder.lossimage.setImageResource(curritem.lossteamimage)
        holder.lossname.text=curritem.lossteamname
        holder.lossrun.text=curritem.lossteamrun
        holder.lossover.text=curritem.lossteamover
        holder.wonby.text=curritem.teamwonby
    }

    override fun getItemCount(): Int {
     return itemslist.count()
    }
}