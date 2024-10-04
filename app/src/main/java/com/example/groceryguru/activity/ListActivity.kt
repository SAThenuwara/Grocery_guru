package com.example.groceryguru.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
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

        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        val db = FirebaseFirestore.getInstance()

        // Get the list of products from Firebase
        db.collection("shoppingList")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val productName = document.getString("name")
                        val productWeight = document.getString("weight")
                        val productImage = document.getString("image")

                        if (productName != null && productWeight != null && productImage != null) {
                            addProductToList(productName, productWeight, productImage, listLayout)
                        }
                    }
                } else {
                    Toast.makeText(this, "Error getting documents.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // Function to dynamically add product to list layout
    private fun addProductToList(productName: String, productWeight: String, productImage: String, listLayout: LinearLayout) {
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

        // Add the views to the text layout
        textLayout.addView(productNameView)
        textLayout.addView(productWeightView)
        productLayout.addView(productImageView)
        productLayout.addView(textLayout)

        // Add product layout to the list
        listLayout.addView(productLayout)
    }
}
