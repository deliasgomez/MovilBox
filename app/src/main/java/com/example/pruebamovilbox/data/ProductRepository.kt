package com.example.pruebamovilbox.data

import com.example.pruebamovilbox.data.database.daos.ProductDao
import com.example.pruebamovilbox.data.model.ProductResponse
import com.example.pruebamovilbox.data.network.ProductService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api : ProductService,
    private val productDao: ProductDao

) {

    suspend fun getAllProductsFromApi():ProductResponse{
        val response = api.getProducts()
        return response
    }



}