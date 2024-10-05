package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R
import com.google.firebase.firestore.FirebaseFirestore

class MeatsCategoryActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    // Define product names, weights, and image resources
    private val productNames = arrayOf("Chicken Breast", "Beef", "Pork", "Pepperoni", "Mutton", "Duck")
    private val productWeights = arrayOf("1kg", "500g", "500g", "1kg", "1kg", "500g")
    private val productImages = arrayOf(
        R.drawable.chicken_breast,
        R.drawable.beef,
        R.drawable.pork,
        R.drawable.pepperoni,
        R.drawable.mutton,
        R.drawable.duck
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meats_category)

        // Set up click listener for the back button
        val backButton: ImageView = findViewById(R.id.imageView6) // Ensure this ID matches your layout
        backButton.setOnClickListener {
            // Navigate back to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Optional: Call finish() if you want to remove this activity from the back stack
        }

        // Set up click listeners for each add to list button
        findViewById<Button>(R.id.addToListButton1).setOnClickListener { addToList(0) }
        findViewById<Button>(R.id.addToListButton2).setOnClickListener { addToList(1) }
        findViewById<Button>(R.id.addToListButton3).setOnClickListener { addToList(2) }
        findViewById<Button>(R.id.addToListButton4).setOnClickListener { addToList(3) }
        findViewById<Button>(R.id.addToListButton5).setOnClickListener { addToList(4) }
        findViewById<Button>(R.id.addToListButton6).setOnClickListener { addToList(5) }
    }

    private fun addToList(productIndex: Int) {
        val product = hashMapOf(
            "name" to productNames[productIndex],
            "weight" to productWeights[productIndex],
            "image" to productImages[productIndex].toString() // Store image resource as string
        )

        db.collection("shoppingList")
            .add(product)
            .addOnSuccessListener {
                Toast.makeText(this, "${productNames[productIndex]} added to list!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error adding product: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}