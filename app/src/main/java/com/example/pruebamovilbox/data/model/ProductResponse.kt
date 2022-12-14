package com.example.pruebamovilbox.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductResponse(
    @SerializedName("products")
    val products : List<Product>

):Parcelable{
    constructor(): this(mutableListOf())
}