package com.example.pruebamovilbox.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebamovilbox.domain.model.ProductDomain
import com.google.gson.annotations.SerializedName


@Entity(tableName = "product_table")
data class ProductEntity(
    @ColumnInfo(name = "brand") val mark: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "discountPercentage") val discountPercentage: Double,
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "rating") val rating: Double,
    @ColumnInfo(name = "stock") val stock: Int,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "title") val title: String

)

fun ProductDomain.toDatabase() = ProductEntity(
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
