package com.example.contact_manager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel


class infopage : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview= inflater.inflate(R.layout.fragment_infopage, container, false)
        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.messi,"football",ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.messi,"football",ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.messi,"football",ScaleTypes.CENTER_CROP))
        val imageSlider = rootview.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        val coachverify=rootview.findViewById<TextView>(R.id.coachverify)
        coachverify.setOnClickListener(){
            val intent=Intent(requireContext(),form1::class.java)
            startActivity(intent)
        }
        return rootview

    }

    companion object {

            }
    }
