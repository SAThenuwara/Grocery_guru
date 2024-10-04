package com.example.groceryguru.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryguru.R
import com.google.firebase.firestore.FirebaseFirestore
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
//import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Find image views by their IDs
        val imageView1: ImageView = findViewById(R.id.imageView3)
        val imageView2: ImageView = findViewById(R.id.imageView4)
        val imageView3: ImageView = findViewById(R.id.imageView5)

        val db = FirebaseFirestore.getInstance()

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

        val addToListButton1 = findViewById<Button>(R.id.addToListButton1)
        addToListButton1.setOnClickListener {
            // Product details
            val productName = "USA Red Apples"
            val productWeight = "500g"
            val productImage = "product1"

            val product = hashMapOf(
                "name" to productName,
                "weight" to productWeight,
                "image" to productImage
            )


        db.collection("shoppingList")
            .add(product)
            .addOnSuccessListener {
                // Successfully added to Firestore
                Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                // Error adding document
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

        val addToListButton2 = findViewById<Button>(R.id.addToListButton2)
        addToListButton2.setOnClickListener {
            // Product details
            val productName = "USA Green Apples"
            val productWeight = "500g"
            val productImage = "product2"

            val product = hashMapOf(
                "name" to productName,
                "weight" to productWeight,
                "image" to productImage
            )


            db.collection("shoppingList")
                .add(product)
                .addOnSuccessListener {
                    // Successfully added to Firestore
                    Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    // Error adding document
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val addToListButton3 = findViewById<Button>(R.id.addToListButton3)
        addToListButton3.setOnClickListener {
            // Product details
            val productName = "Bananas"
            val productWeight = "1Kg"
            val productImage = "product3"

            val product = hashMapOf(
                "name" to productName,
                "weight" to productWeight,
                "image" to productImage
            )


            db.collection("shoppingList")
                .add(product)
                .addOnSuccessListener {
                    // Successfully added to Firestore
                    Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    // Error adding document
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val addToListButton4 = findViewById<Button>(R.id.addToListButton4)
        addToListButton4.setOnClickListener {
            // Product details
            val productName = "Fresh Tomatoes"
            val productWeight = "1Kg"
            val productImage = "product4"

            val product = hashMapOf(
                "name" to productName,
                "weight" to productWeight,
                "image" to productImage
            )


            db.collection("shoppingList")
                .add(product)
                .addOnSuccessListener {
                    // Successfully added to Firestore
                    Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    // Error adding document
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val addToListButton5 = findViewById<Button>(R.id.addToListButton5)
        addToListButton5.setOnClickListener {
            // Product details
            val productName = "Chicken Breast"
            val productWeight = "1Kg"
            val productImage = "product5"

            val product = hashMapOf(
                "name" to productName,
                "weight" to productWeight,
                "image" to productImage
            )


            db.collection("shoppingList")
                .add(product)
                .addOnSuccessListener {
                    // Successfully added to Firestore
                    Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    // Error adding document
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val addToListButton6 = findViewById<Button>(R.id.addToListButton6)
        addToListButton6.setOnClickListener {
            // Product details
            val productName = "Eggs"
            val productWeight = "12 Pieces"
            val productImage = "product6"

            val product = hashMapOf(
                "name" to productName,
                "weight" to productWeight,
                "image" to productImage
            )


            db.collection("shoppingList")
                .add(product)
                .addOnSuccessListener {
                    // Successfully added to Firestore
                    Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    // Error adding document
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val profileIcon = findViewById<ImageView>(R.id.imageViewProfile)
        val cartIcon = findViewById<ImageView>(R.id.cart)
        val shutdownIcon = findViewById<ImageView>(R.id.shutoff)

// Profile Icon - Open AccountActivity
        profileIcon.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

// Cart Icon - Open ListActivity
        cartIcon.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

//// Shutdown Icon - Show confirmation dialog and log out user
//        shutdownIcon.setOnClickListener {
//            showLogoutConfirmationDialog()
//        }
//
//
//    }

//    private fun showLogoutConfirmationDialog() {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Logout Confirmation")
//        builder.setMessage("Are you sure you want to log out?")
//
//        // Set positive button for confirming logout
//        builder.setPositiveButton("Yes") { dialog, _ ->
//            // Log out the user and redirect to LoginActivity (or whichever screen)
//            FirebaseAuth.getInstance().signOut()
//            val intent = Intent(this, LoginActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//            finish()
//            dialog.dismiss() // close the dialog
//        }
//
//        // Set negative button for canceling logout
//        builder.setNegativeButton("No") { dialog, _ ->
//            dialog.dismiss() // close the dialog
//        }
//
//        val dialog = builder.create()
//        dialog.show()
   }
}
