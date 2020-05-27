package com.smartherd.msgshareapp

import android.app.Activity
import android.content.Context
import android.widget.Toast

// #4.2.1 Making an extension function
// #1 - create a normal function
// #2 - Add the Activity. with the function name which makes the function part of the Activity
// #3 - Or you can add Context. with the function name to access the class from anywhere of the application

// Note: Context is the super class of Activity. therefore using Context. with the function name enables the function to be accessed from Activity or adapter

// Basic implementation just to pass message
// fun Context.showToast(message : String)


// In this implementation the duration of the Toast message can be change dynamically
fun Context.showToast(message : String, duration : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()
}