package com.example.pruebamovilbox.domain.useCases

import com.example.pruebamovilbox.data.ProductRepository
import com.example.pruebamovilbox.domain.model.ProductDomain
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(id:Int) :ProductDomain {
        val product = repository.getProductById(id)
        return product
    }
}