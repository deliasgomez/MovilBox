package com.example.pruebamovilbox.data.network

import com.example.pruebamovilbox.core.RetrofitHelper
import com.example.pruebamovilbox.data.model.Product
import com.example.pruebamovilbox.data.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ProductService @Inject constructor(private val api : ProductApiClient) {

    suspend fun getProducts() : ProductResponse {
        return withContext(Dispatchers.IO){
            val response : Response<ProductResponse> = api.getAllProducts()
            (response.body() ?: mutableListOf<Product>()) as ProductResponse

        }
    }
}