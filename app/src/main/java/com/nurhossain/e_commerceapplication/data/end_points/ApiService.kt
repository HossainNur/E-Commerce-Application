package com.nurhossain.e_commerceapplication.data.end_points

import com.nurhossain.e_commerceapplication.data.model.ProductCategoryItem
import retrofit2.http.GET

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): List<ProductCategoryItem>
}