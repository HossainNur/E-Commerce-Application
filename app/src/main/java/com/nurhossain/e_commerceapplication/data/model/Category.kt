package com.nurhossain.e_commerceapplication.data.model


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("creationAt")
    val creationAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)