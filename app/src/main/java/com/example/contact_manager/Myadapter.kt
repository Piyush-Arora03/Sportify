package com.example.recyclerview

import android.app.Activity
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_manager.R

class Myadapter(val itemlist:ArrayList<sport>,val context: Activity):
    RecyclerView.Adapter<Myadapter.MyViewHolder>()
{       private lateinit var mylistener : onitemclicklistener

        interface onitemclicklistener{
       fun Onitemclick(position: Int)
        }

   fun setitemclicklistener(ourListener :onitemclicklistener){
        mylistener=ourListener
    }

    class MyViewHolder(itemView: View , listener:onitemclicklistener): RecyclerView.ViewHolder(itemView) {
        val heading=itemView.findViewById<TextView>(R.id.heading)
        val himage=itemView.findViewById<ImageView>(R.id.image)

        init {
            itemView.setOnClickListener() {
                listener.Onitemclick(adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.sportsview,parent,false)
        return MyViewHolder(view,mylistener)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data=itemlist[position]
        holder.himage.setImageResource(data.image)
        holder.heading.text=data.name

    }


}