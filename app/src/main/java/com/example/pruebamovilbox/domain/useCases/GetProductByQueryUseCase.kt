package com.example.pruebamovilbox.domain.useCases

import com.example.pruebamovilbox.data.ProductRepository
import com.example.pruebamovilbox.domain.model.ProductDomain
import javax.inject.Inject

class GetProductByQueryUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(query : String) : List<ProductDomain> {
        val products = repository.getProductByQuery(query)
        return products
    }

}