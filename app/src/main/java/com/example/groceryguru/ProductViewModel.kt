package com.example.groceryguru

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ProductViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun addProductToFirestore(product: com.example.groceryguru.Product) {
        db.collection("products")
            .add(product)
            .addOnSuccessListener { documentReference ->
                Log.d("Firestore", "Product added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error adding product", e)
            }
    }
}

