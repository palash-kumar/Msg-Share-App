package com.smartherd.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.smartherd.msgshareapp.Constants
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonShowToast.setOnClickListener{
            Log.i("MainActivity", "Button was clicked");

            // Calling the toast from extenstion Extension,kt
            // Here we are not implementing the second parameter, as we have set a default value for the duration
            // If we wanr to change the duration whe can simply add Toast.LENGTH_LONG as a second parameter
            showToast(resources.getString(R.string.buttonWasClicked))
            // Displaying a popup message for short length
            //Toast.makeText(this, "Button was clicked!!",Toast.LENGTH_SHORT).show();
        }

        btnSendMessageToNextActivity.setOnClickListener{

            val message: String = userMessage.text.toString();

            //Toast.makeText(this, message,Toast.LENGTH_SHORT).show();

            /* Navigating to second Activity or second screen of the application
            // Intent = Intention of doing something
            // Two types of Intent :    1 - Explicit = The target Activity is known,
                                        2 - Implicit = Target Activity is not known
            // Here we have implemented Explicit Intent as we know the target Activity which is SecondActivity
             */
            val intent = Intent(this, SecondActivity::class.java);


            // way -1  sending the message to next activity
            //intent.putExtra("user_message", message);

            /* way -2 here we have used a created constant string from the object AppConstant.kt
             it makes the key-value pairing easy and eleminates the possibility of making
             any mistake which can be caused by the key.
             now we can use  Constants.USER_MSG_KEY to call for the value from any classs
             without worrying about making any mistake in key.
             */
            intent.putExtra(Constants.USER_MSG_KEY, message);

            startActivity(intent);
        }

        // Here we have implemented Implicit Intent as we DO NOT KNOW the target Activity basically to login or share data externally
        buttonShareToOtherApps.setOnClickListener {

            val message: String = userMessage.text.toString();

            val intent = Intent();
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share To : "))


        }

        hobbyList.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)

            startActivity(intent)
        }
    }
}
