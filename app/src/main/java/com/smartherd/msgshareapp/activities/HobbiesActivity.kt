package com.smartherd.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.msgshareapp.adapters.HobbiesAdapter
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity(){

    /*
    * #3.4 The activity controller which will show the hobbies list on the screen to the user
    * or it contains the layout manager for the recycler view
    * and links the recyclerView to the custom adapter HobbiesAdapter.kt
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        // Setting the layout manager
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManager

        // Linking the adapter with hobbies model
        val adapter = HobbiesAdapter(
            this,
            Supplier.hobbies
        ) //  this = currentContext and hobbies lis is sent to the adapter

        recyclerView.adapter = adapter
    }
}