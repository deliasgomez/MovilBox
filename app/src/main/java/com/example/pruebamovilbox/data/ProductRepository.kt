package com.example.pruebamovilbox.data

import com.example.pruebamovilbox.data.database.daos.ProductDao
import com.example.pruebamovilbox.data.database.entities.ProductEntity
import com.example.pruebamovilbox.data.network.ProductService
import com.example.pruebamovilbox.domain.model.ProductDomain
import com.example.pruebamovilbox.domain.model.toDomain
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api : ProductService,
    private val productDao: ProductDao

) {

    suspend fun getAllProductsFromApi():List<ProductDomain>{
        val response = api.getProducts()
        return response.map { it.toDomain() }
    }


    suspend fun getAllProductsFromDatabase():List<ProductDomain>{
        val response = productDao.getAllProducts()
        return response.map { it.toDomain() }


    }

    suspend fun insertProducts(products : List<ProductEntity>){
        productDao.insertAll(products)
    }

    suspend fun clearProducts(){
        productDao.deleteAllProducts()
    }

    suspend fun getProductById(id : Int):ProductDomain{
        val response =  productDao.getProductById(id)
        return response.toDomain()
    }


}