package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        // Find the "Create Account" button by its ID
        val createAccountButton: Button = findViewById(R.id.createAccountButton)

        // Set an OnClickListener on the button
        createAccountButton.setOnClickListener {
            // Create an Intent to start the SignupActivity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)


        }
    }
}