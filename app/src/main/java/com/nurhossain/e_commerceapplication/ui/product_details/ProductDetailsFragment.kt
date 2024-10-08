package com.nurhossain.e_commerceapplication.ui.product_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurhossain.e_commerceapplication.R
import com.nurhossain.e_commerceapplication.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentProductDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}