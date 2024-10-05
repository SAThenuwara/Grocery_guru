package com.example.groceryguru.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.groceryguru.R

class SearchRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search_recipe)

        val backButton: ImageView = findViewById(R.id.backIcon) // Ensure this ID matches your layout
        backButton.setOnClickListener {
            finish() // Navigate back to the previous activity
        }

        }
    }
