package com.nurhossain.e_commerceapplication.repository

import com.nurhossain.e_commerceapplication.data.end_points.RetrofitClient
import com.nurhossain.e_commerceapplication.data.model.ProductCategoryItem

class ProductCategoryRepository {
    suspend fun getCategories(): List<ProductCategoryItem> {
        return RetrofitClient.api.getCategories()
    }
}