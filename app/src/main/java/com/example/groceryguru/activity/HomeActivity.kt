package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Find image views by their IDs
        val imageView1: ImageView = findViewById(R.id.imageView3)
        val imageView2: ImageView = findViewById(R.id.imageView4)
        val imageView3: ImageView = findViewById(R.id.imageView5)

        // Set OnClickListener for the first image view (Banner 1)
        imageView1.setOnClickListener {
            // Redirect to RecipeDescription1Activity when the first banner is clicked
            val intent = Intent(this, RecipeDescription1Activity::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for the second image view (Banner 2)
        imageView2.setOnClickListener {
            // Redirect to RecipeDescription2Activity when the second banner is clicked
            val intent = Intent(this, RecipeDescription2Activity::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for the third image view (Banner 3)
        imageView3.setOnClickListener {
            // Redirect to RecipeDescription3Activity when the third banner is clicked
            val intent = Intent(this, RecipeDescription3Activity::class.java)
            startActivity(intent)
        }
        val dairyIcon: ImageView = findViewById(R.id.dairyIcon)
        val fruitsIcon: ImageView = findViewById(R.id.fruitsIcon)
        val vegetablesIcon: ImageView = findViewById(R.id.vegetablesIcon)
        val meatsIcon: ImageView = findViewById(R.id.meatsIcon)
        val fishIcon: ImageView = findViewById(R.id.fishIcon)

        // Set OnClickListener for Dairy Icon
        dairyIcon.setOnClickListener {
            val intent = Intent(this, OtherCategoryActivity::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for Fruits Icon
        fruitsIcon.setOnClickListener {
            val intent = Intent(this, FruitsCategoryActivity::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for Vegetables Icon
        vegetablesIcon.setOnClickListener {
            val intent = Intent(this, VegetablesCategoryActivity::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for Meats Icon
        meatsIcon.setOnClickListener {
            val intent = Intent(this, MeatsCategoryActivity::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for Fish Icon
        fishIcon.setOnClickListener {
            val intent = Intent(this, FishCategoryActivity::class.java)
            startActivity(intent)
        }
    }
}
