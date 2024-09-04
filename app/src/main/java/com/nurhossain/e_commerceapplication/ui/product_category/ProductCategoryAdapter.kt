package com.nurhossain.e_commerceapplication.ui.product_category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nurhossain.e_commerceapplication.R
import com.nurhossain.e_commerceapplication.data.model.ProductCategoryItem
import com.squareup.picasso.Picasso

class ProductCategoryAdapter(private val categories: List<ProductCategoryItem>,private val callBack: (Int) -> Unit) : RecyclerView.Adapter<ProductCategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.nameTextView.text = category.name
        Picasso.get().load(category.image).into(holder.imageView)
        holder.imageView.setOnClickListener {
            category.id?.let { it1 -> callBack(it1) }
        }
    }

    override fun getItemCount(): Int = categories.size


    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.category_image)
        val nameTextView: TextView = itemView.findViewById(R.id.category_name)
    }
}