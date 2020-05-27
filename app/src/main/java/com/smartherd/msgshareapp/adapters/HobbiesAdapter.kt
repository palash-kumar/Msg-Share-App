package com.smartherd.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.msgshareapp.models.Hobby
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

/*
* #3.5 This is the adapter class where the model data is combined to the view
* the data from Model.kt (var hobbies) is set to the view end HobbiesActivity.kt
* */
class HobbiesAdapter(val context:Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){

    // This function is used to render the contents of activity
    inner class MyViewHolder(intemView : View) : RecyclerView.ViewHolder(intemView){

        // Creating variables to hold the values
        var currentHobby: Hobby? = null // Declaring/ Inititating the hobby class
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                //Accessing Extension function showToast(msg) from Adapt3er class
                context.showToast(currentHobby!!.title+" Clicked!!")
                //Toast.makeText(context, currentHobby!!.title+" Clicked!!", Toast.LENGTH_SHORT).show() // ? is used for not null check
            }

            itemView.imgShare.setOnClickListener {

                val message: String = "My Hobby is : "+currentHobby!!.title

                val intent = Intent();
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Share To : "))
            }
        }
        // loads the title from model class to the view
        fun setData(hobby: Hobby?, position: Int){
              itemView.txvTitle.text = hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = position
        }
    }

    // Following functions are inherited from RecyclerView.Adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        // False indicates that if we want to attach the layout with root or not
        // .inflate method or function returns the layout as view. In this case list_items is returned as view

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        Log.i("Hobbies Activity", "Button was clicked"+hobbies.size);
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}