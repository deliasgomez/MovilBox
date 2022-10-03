package com.example.pruebamovilbox.domain.useCases

import com.example.pruebamovilbox.data.ProductRepository
import com.example.pruebamovilbox.domain.model.ProductDomain
import javax.inject.Inject

class GetOrderByRatingUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke() : List<ProductDomain> {
        val products = repository.getOrderByRating()
        return products
    }
}