package com.example.pruebamovilbox.domain.model

import com.example.pruebamovilbox.data.database.entities.ProductEntity
import com.example.pruebamovilbox.data.model.Product


data class ProductDomain(
    val mark: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)

fun Product.toDomain() = ProductDomain(
     mark,
    category,
    description,
    discountPercentage,
    id,
    price,
    rating,
    stock,
    thumbnail,
    title
)

fun ProductEntity.toDomain() = ProductDomain(
    mark,
    category,
    description,
    discountPercentage,
    id,
    price,
    rating,
    stock,
    thumbnail,
    title
)
