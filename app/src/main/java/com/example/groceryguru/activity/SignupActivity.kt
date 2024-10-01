package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.groceryguru.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        // Find the "Create Account" button by its ID
        val createAccountButton: Button = findViewById(R.id.signUpButton)

        // Set an OnClickListener on the button
        createAccountButton.setOnClickListener {
            // Create an Intent to start the SignupActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}