package com.example.pruebamovilbox.data.network

import com.example.pruebamovilbox.data.model.Product
import com.example.pruebamovilbox.data.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {

    @GET("products")
    suspend fun getAllProducts(): Response<ProductResponse>




}