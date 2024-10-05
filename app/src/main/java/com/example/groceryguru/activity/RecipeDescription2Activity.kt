package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R
import com.google.firebase.firestore.FirebaseFirestore

class RecipeDescription2Activity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_description2)


        val showMoreButton: Button = findViewById(R.id.showMoreButton)

// Set an OnClickListener to navigate to SearchRecipeActivity
        showMoreButton.setOnClickListener {
            val intent = Intent(this, SearchRecipeActivity::class.java)
            startActivity(intent)
        }
        // Set up click listener for the back button
        val backButton: ImageView = findViewById(R.id.backIcon) // Ensure this ID matches your layout
        backButton.setOnClickListener {
            finish() // Navigate back to the previous activity
        }

        // Set up click listener for the "Add to List" button
        findViewById<Button>(R.id.addToListButton).setOnClickListener {
            addToRecipeList()
        }
    }

    private fun addToRecipeList() {
        // Define recipe details (you can also retrieve these from your UI elements)
        val recipeName = "Pepperoni Pizza"
        val recipeLevel = "Intermediate"
        val recipeImage = R.drawable.pepperoni_pizza.toString() // Store image resource as string

        val recipe = hashMapOf(
            "name" to recipeName,
            "level" to recipeLevel,
            "image" to recipeImage
        )

        db.collection("recipeList")
            .add(recipe)
            .addOnSuccessListener {
                Toast.makeText(this, "$recipeName added to your recipe list!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error adding recipe: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
