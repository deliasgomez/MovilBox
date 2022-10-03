package com.example.pruebamovilbox.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebamovilbox.domain.GetProductByIdUseCase
import com.example.pruebamovilbox.domain.model.ProductDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsActivityViewModel @Inject constructor(
    private val getProductByIdUseCase : GetProductByIdUseCase
)  : ViewModel() {
    private val _product = MutableLiveData<ProductDomain>()
    val product : MutableLiveData<ProductDomain> get() = _product

    fun getProductById(id:Int){
        viewModelScope.launch {
            val product = getProductByIdUseCase(id)
            _product.postValue(product)
        }
    }





}