package com.example.groceryguru.activity

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R
import com.google.firebase.firestore.FirebaseFirestore

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Set up the back button
        val backIcon = findViewById<ImageView>(R.id.backIcon)
        backIcon.setOnClickListener {
            finish() // Close current activity and go back
        }

        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        val db = FirebaseFirestore.getInstance()

        // Set the parent layout orientation to vertical
        listLayout.orientation = LinearLayout.VERTICAL

        // Get the list of products from Firebase
        db.collection("shoppingList")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val productName = document.getString("name")
                        val productWeight = document.getString("weight")
                        val productImage = document.getString("image")
                        val productQuantity = document.getLong("quantity")?.toInt() ?: 1 // Default to 1 if null

                        if (productName != null && productWeight != null && productImage != null) {
                            addProductToList(productName, productWeight, productImage, productQuantity, listLayout)
                        }
                    }
                } else {
                    Toast.makeText(this, "Error getting documents.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addProductToList(productName: String, productWeight: String, productImage: String, initialQuantity: Int, listLayout: LinearLayout) {
        // Create the layout for each product dynamically
        val productLayout = LinearLayout(this)
        productLayout.orientation = LinearLayout.HORIZONTAL
        productLayout.setBackgroundColor(Color.WHITE)
        productLayout.setPadding(8, 8, 8, 8)
        productLayout.gravity = Gravity.CENTER_VERTICAL

        // Create ImageView for product image
        val productImageView = ImageView(this)
        val imageResId = resources.getIdentifier(productImage, "drawable", packageName)
        productImageView.setImageResource(imageResId)
        val imageParams = LinearLayout.LayoutParams(70, 70)
        productImageView.layoutParams = imageParams

        // Create a vertical layout for text
        val textLayout = LinearLayout(this)
        textLayout.orientation = LinearLayout.VERTICAL
        textLayout.setPadding(8, 0, 0, 0)
        val textLayoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        textLayout.layoutParams = textLayoutParams

        // Create TextView for product name
        val productNameView = TextView(this)
        productNameView.text = productName
        productNameView.textSize = 16f
        productNameView.setTypeface(null, Typeface.BOLD)

        // Create TextView for product weight
        val productWeightView = TextView(this)
        productWeightView.text = "Weight: $productWeight"
        productWeightView.textSize = 14f

        // Create TextView for product quantity
        val productQuantityView = TextView(this)
        var productQuantity = initialQuantity // Change to var to make it mutable
        productQuantityView.text = "Quantity: $productQuantity"
        productQuantityView.textSize = 14f

        // Create layout for quantity controls
        val quantityLayout = LinearLayout(this)
        quantityLayout.orientation = LinearLayout.HORIZONTAL

        // Create button to decrease quantity
        val decreaseButton = Button(this)
        decreaseButton.text = "-"
        decreaseButton.setOnClickListener {
            if (productQuantity > 1) {
                productQuantity-- // Decrease the quantity
                productQuantityView.text = "Quantity: $productQuantity"
                // Update Firestore with new quantity if needed
                updateProductQuantityInFirestore(productName, productQuantity)
            }
        }

        // Create button to increase quantity
        val increaseButton = Button(this)
        increaseButton.text = "+"
        increaseButton.setOnClickListener {
            productQuantity++ // Increase the quantity
            productQuantityView.text = "Quantity: $productQuantity"
            // Update Firestore with new quantity if needed
            updateProductQuantityInFirestore(productName, productQuantity)
        }

        // Create remove button (X icon)
        val removeButton = Button(this)
        removeButton.text = "X" // You can set a drawable for the button
        removeButton.setOnClickListener {
            // Remove this product from the list and Firestore
            removeProductFromFirestore(productName)
            listLayout.removeView(productLayout) // Remove from UI
        }

        // Add the buttons to the quantity layout
        quantityLayout.addView(decreaseButton)
        quantityLayout.addView(productQuantityView)
        quantityLayout.addView(increaseButton)
        quantityLayout.addView(removeButton) // Add the remove button

        // Add the views to the text layout
        textLayout.addView(productNameView)
        textLayout.addView(productWeightView)
        textLayout.addView(quantityLayout) // Add the quantity controls
        productLayout.addView(productImageView)
        productLayout.addView(textLayout)

        // Add product layout to the list
        listLayout.addView(productLayout)
    }

    private fun updateProductQuantityInFirestore(productName: String, quantity: Int) {
        val db = FirebaseFirestore.getInstance()

        // Assuming that each product has a unique name, you might want to adjust this if you have unique IDs
        db.collection("shoppingList")
            .whereEqualTo("name", productName)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    // Update the quantity field in Firestore
                    db.collection("shoppingList").document(document.id)
                        .update("quantity", quantity)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Quantity updated", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error updating quantity: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error finding product: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
    private fun removeProductFromFirestore(productName: String) {
        val db = FirebaseFirestore.getInstance()

        // Assuming that each product has a unique name, you might want to adjust this if you have unique IDs
        db.collection("shoppingList")
            .whereEqualTo("name", productName)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    // Delete the document from Firestore
                    db.collection("shoppingList").document(document.id)
                        .delete()
                        .addOnSuccessListener {
                            Toast.makeText(this, "Product removed", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error removing product: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error finding product: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }


}