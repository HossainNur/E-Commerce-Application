package com.nurhossain.e_commerceapplication.repository

import com.nurhossain.e_commerceapplication.data.end_points.RetrofitClient
import com.nurhossain.e_commerceapplication.data.model.Product
import com.nurhossain.e_commerceapplication.data.model.ProductCategoryItem

class ProductRepository {
    private val apiService = RetrofitClient.api

    suspend fun getProducts(categoryId: Int): List<Product> {
        return apiService.getProducts(categoryId)
    }

    /*suspend fun getProducts(categoryId: Int): List<Product> {
        return RetrofitClient.api.getProducts(categoryId)
    }*/
}