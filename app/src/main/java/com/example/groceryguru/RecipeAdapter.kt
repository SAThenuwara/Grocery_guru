package com.example.groceryguru.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryguru.R

data class Recipe(
    val name: String,
    val level: String,
    val image: String,
    val id: String // Store Firestore document ID
)

class RecipeAdapter(
    private val recipes: List<Recipe>,
    private val onRemoveClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipes.size

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeName: TextView = itemView.findViewById(R.id.recipeName)
        private val recipeLevel: TextView = itemView.findViewById(R.id.recipeLevel)
        private val recipeImage: ImageView = itemView.findViewById(R.id.recipeImage)
        private val removeButton: ImageView = itemView.findViewById(R.id.removeButton)

        fun bind(recipe: Recipe) {
            recipeName.text = recipe.name
            recipeLevel.text = recipe.level
            // Load image using an image loading library like Glide or Picasso
            // For example: Glide.with(itemView).load(recipe.image).into(recipeImage);
            removeButton.setOnClickListener { onRemoveClick(recipe) }
        }
    }
}
