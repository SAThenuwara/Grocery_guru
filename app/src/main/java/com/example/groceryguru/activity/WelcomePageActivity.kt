package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R

class WelcomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the welcome page layout
        setContentView(R.layout.activity_welcome_page)

        val createAccountButton: Button = findViewById(R.id.getStartedButton)

        createAccountButton.setOnClickListener {
            // Create an Intent to start the SignupActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }
}
