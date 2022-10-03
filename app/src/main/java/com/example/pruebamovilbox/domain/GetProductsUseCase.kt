package com.example.pruebamovilbox.domain

import com.example.pruebamovilbox.data.ProductRepository
import com.example.pruebamovilbox.data.model.ProductResponse
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke() :ProductResponse = repository.getAllProductsFromApi()

}