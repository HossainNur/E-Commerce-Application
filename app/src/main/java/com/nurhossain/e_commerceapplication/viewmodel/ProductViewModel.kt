package com.nurhossain.e_commerceapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nurhossain.e_commerceapplication.data.model.Product
import com.nurhossain.e_commerceapplication.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ProductRepository()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        fetchProducts(2)
    }

    private fun fetchProducts(id:Int) {
        viewModelScope.launch {
            try {
                _products.value = repository.getProducts(categoryId = id)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}