package com.nurhossain.e_commerceapplication.data.end_points

import com.nurhossain.e_commerceapplication.data.model.Product
import com.nurhossain.e_commerceapplication.data.model.ProductCategoryItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): List<ProductCategoryItem>
    @GET("categories/{id}/products")
    suspend fun getProducts(@Path("id") categoryId: Int): List<Product>
}