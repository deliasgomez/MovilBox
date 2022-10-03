package com.example.pruebamovilbox.presentation.view

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.example.pruebamovilbox.R
import com.example.pruebamovilbox.databinding.ActivityDetailsBinding
import com.example.pruebamovilbox.presentation.viewModel.DetailsActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel : DetailsActivityViewModel by viewModels()

        val id = intent.getIntExtra("ID",0)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.product_details)

        viewModel.getProductById(id)
        viewModel.product.observe(this,{
            binding.tvProduct.text = it.title
            binding.categoryProduct.text = "Category: ${it.category}"
            binding.tvDescriptionContent.text = it.description
            binding.tvPrice.text = "Precio : $ ${it.price}"
            binding.tvRating.text = "Rating: ${it.rating}"
            binding.tvDiscountPercentage.text = "Porcentaje de descuento : ${it.discountPercentage}"
            binding.tvStock.text = "Cantidades disponibles : ${it.stock}"

            Glide.with(this)
                .load(it.thumbnail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imageProduct)
        })


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }



}