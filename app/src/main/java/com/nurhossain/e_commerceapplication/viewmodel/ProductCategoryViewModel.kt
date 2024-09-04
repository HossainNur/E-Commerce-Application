package com.nurhossain.e_commerceapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhossain.e_commerceapplication.data.Resource
import com.nurhossain.e_commerceapplication.data.model.ProductCategoryItem
import com.nurhossain.e_commerceapplication.repository.ProductCategoryRepository
import kotlinx.coroutines.launch

class ProductCategoryViewModel: ViewModel() {
    private val repository = ProductCategoryRepository()
    val categories = MutableLiveData<Resource<List<ProductCategoryItem>>>()

    fun fetchCategories() {
        categories.postValue(Resource.loading())
        viewModelScope.launch {
            try {
                val response = repository.getCategories()
                categories.postValue(Resource.success(response))
            } catch (e: Exception) {
                categories.postValue(Resource.error("Failed to load categories: ${e.message}"))
            }
        }
    }
}