package com.example.pruebamovilbox.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebamovilbox.data.model.Product
import com.example.pruebamovilbox.data.model.ProductResponse
import com.example.pruebamovilbox.domain.GetProductsUseCase
import com.example.pruebamovilbox.domain.model.ProductDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _products = MutableLiveData<List<ProductDomain>>()
    val products: LiveData<List<ProductDomain>> get() = _products



    fun getProduct(){
        viewModelScope.launch {
            val result = getProductsUseCase()
            _products.postValue(result)
        }


    }

}