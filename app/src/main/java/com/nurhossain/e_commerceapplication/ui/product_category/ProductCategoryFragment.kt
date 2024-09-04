package com.nurhossain.e_commerceapplication.ui.product_category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nurhossain.e_commerceapplication.R
import com.nurhossain.e_commerceapplication.data.Resource
import com.nurhossain.e_commerceapplication.data.Status
import com.nurhossain.e_commerceapplication.databinding.FragmentProductCategoryBinding
import com.nurhossain.e_commerceapplication.viewmodel.ProductCategoryViewModel

class ProductCategoryFragment : Fragment() {

    private lateinit var binding: FragmentProductCategoryBinding
    private val viewModel: ProductCategoryViewModel by viewModels()
    private lateinit var productCategoryAdapter: ProductCategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentProductCategoryBinding.inflate(layoutInflater,container,false)

        viewModel.fetchCategories()

        viewModel.categories.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    showLoadingScreen()
                }

                Status.SUCCESS -> {
                    if (it.data != null){
                        productCategoryAdapter = ProductCategoryAdapter(it.data){
                            findNavController().navigate(R.id.productListFragment)
                        }
                        binding.homeCategoriesRv.adapter = productCategoryAdapter
                    }
                    hideLoadingScreen()
                }

                Status.ERROR -> {
                    hideLoadingScreen()
                }
            }
        }

        return binding.root
    }

    private fun hideLoadingScreen() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoadingScreen() {
        binding.progressBar.visibility = View.VISIBLE
    }

}