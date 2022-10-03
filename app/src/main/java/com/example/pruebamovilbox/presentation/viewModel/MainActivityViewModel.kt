package com.example.pruebamovilbox.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebamovilbox.domain.useCases.GetOrderByCategoryUseCase
import com.example.pruebamovilbox.domain.useCases.GetOrderByPriceUseCase
import com.example.pruebamovilbox.domain.useCases.GetProductsUseCase
import com.example.pruebamovilbox.domain.model.ProductDomain
import com.example.pruebamovilbox.domain.useCases.GetOrderByRatingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getOrderByPriceUseCase : GetOrderByPriceUseCase,
    private val getOrderByCategoryUseCase : GetOrderByCategoryUseCase,
    private val getOrderByRatingUseCase : GetOrderByRatingUseCase
) : ViewModel() {
    private val _products = MutableLiveData<List<ProductDomain>>()
    val products: LiveData<List<ProductDomain>> get() = _products



    fun getProduct(){
        viewModelScope.launch {
            val result = getProductsUseCase()
            _products.postValue(result)
        }


    }

    fun getOrderByPrice(){
        viewModelScope.launch {
            val result = getOrderByPriceUseCase()
            _products.postValue(result)
        }
    }

    fun getOrderByCategory(){
        viewModelScope.launch {
            val result = getOrderByCategoryUseCase()
            _products.postValue(result)
        }
    }

    fun getOrderByRating(){
        viewModelScope.launch {
            val result = getOrderByRatingUseCase()
            _products.postValue(result)
        }
    }


}