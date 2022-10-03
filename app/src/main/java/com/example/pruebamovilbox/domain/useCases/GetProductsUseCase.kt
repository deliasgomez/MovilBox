package com.example.pruebamovilbox.domain.useCases

import com.example.pruebamovilbox.data.ProductRepository
import com.example.pruebamovilbox.data.database.entities.toDatabase
import com.example.pruebamovilbox.domain.model.ProductDomain
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke() : List<ProductDomain> {
        val products = repository.getAllProductsFromApi()

        return if (products.isNotEmpty()){
            repository.clearProducts()
            repository.insertProducts(products.map { it.toDatabase() })
            products

        }else{
            repository.getAllProductsFromDatabase()
        }

    }

}