package com.smartherd.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.Constants
import com.smartherd.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Receiving the message from first activity (.MainActivity)

        /* #4.4.1 Implementing null safety
        Safe call => ?.
        Safe call With LET => ?.let{}
        Not null Assertion Operator => !!
         */
        val bundle: Bundle? =  intent.extras

        // The following statement might provide a null pointer exception or send a message as "null" text
        // therefo9re will will be handling the Null pointer as:
        bundle?.let {
            // Now if the bundke is null the following codes will not be executed preventing nul pointer exception or arbitrary text such as "null"
            //val message = bundle!!.getString("user_message")

            // Here we are calling the same message but using the constant key
            val message = bundle!!.getString(Constants.USER_MSG_KEY)

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            viewUserMessage.text = message;
        }

    }
}