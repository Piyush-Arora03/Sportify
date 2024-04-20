package com.example.contact_manager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import nl.joery.animatedbottombar.AnimatedBottomBar

class navview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_navview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bar=findViewById<AnimatedBottomBar>(R.id.bottom_bar)

        replacewithfrag(infopage())
        bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when(newTab.id){
                    R.id.auc ->replacewithfrag(autionfrag())
                    R.id.home ->replacewithfrag(infopage())
                    R.id.calc ->replacewithfrag(homefrag())
                    R.id.profile -> replacewithactivity()
                }
            }


        })
    }
    private fun replacewithfrag(Fragment: Fragment) {
        val fragman=supportFragmentManager
        val transaction=fragman.beginTransaction()
        transaction.replace(R.id.frame,Fragment)
        transaction.commit()
    }

    private fun replacewithactivity(){
       val intent=Intent(this,auctionregistration::class.java)
        startActivity(intent)
    }
}