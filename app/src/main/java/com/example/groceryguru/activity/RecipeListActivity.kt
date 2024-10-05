package com.example.groceryguru.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryguru.R
import com.example.groceryguru.adapter.Recipe
import com.example.groceryguru.adapter.RecipeAdapter
import com.google.firebase.firestore.FirebaseFirestore

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recipeAdapter: RecipeAdapter
    private val recipeList = mutableListOf<Recipe>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recipeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recipeAdapter = RecipeAdapter(recipeList) { recipe ->
            removeRecipeFromList(recipe)
        }
        recyclerView.adapter = recipeAdapter

        // Fetch recipes from Firestore
        fetchRecipesFromFirestore()
    }

    private fun fetchRecipesFromFirestore() {
        db.collection("recipeList")
            .get()
            .addOnSuccessListener { documents ->
                recipeList.clear() // Clear the list to avoid duplication
                for (document in documents) {
                    val recipeName = document.getString("name") ?: "Unknown"
                    val recipeLevel = document.getString("level") ?: "Unknown"
                    val recipeImage = document.getString("image") ?: R.drawable.ic_recipe_image.toString() // Default image if not found
                    val recipeId = document.id

                    // Add each recipe to the list
                    val recipe = Recipe(recipeName, recipeLevel, recipeImage, recipeId)
                    recipeList.add(recipe)
                }
                recipeAdapter.notifyDataSetChanged() // Notify the adapter to refresh the RecyclerView
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error fetching recipes: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun removeRecipeFromList(recipe: Recipe) {
        db.collection("recipeList").document(recipe.id)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(this, "${recipe.name} removed from the list", Toast.LENGTH_SHORT).show()
                recipeList.remove(recipe) // Remove from the local list
                recipeAdapter.notifyDataSetChanged() // Notify the adapter of the change
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error removing recipe: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
