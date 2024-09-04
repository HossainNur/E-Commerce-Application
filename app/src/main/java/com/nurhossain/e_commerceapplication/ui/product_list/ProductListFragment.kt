package com.nurhossain.e_commerceapplication.ui.product_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.nurhossain.e_commerceapplication.R
import com.nurhossain.e_commerceapplication.databinding.FragmentProductListBinding
import com.nurhossain.e_commerceapplication.viewmodel.ProductViewModel

class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: FragmentProductListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        adapter = ProductAdapter()
        binding.productsRv.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner) { products ->
            adapter.submitList(products)
        }

        return binding.root
    }

}