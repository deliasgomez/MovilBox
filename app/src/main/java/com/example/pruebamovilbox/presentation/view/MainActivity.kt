package com.example.pruebamovilbox.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebamovilbox.R
import com.example.pruebamovilbox.databinding.ActivityMainBinding
import com.example.pruebamovilbox.presentation.adapters.ProductAdapter
import com.example.pruebamovilbox.presentation.view.utils.OnClickListener
import com.example.pruebamovilbox.presentation.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel : MainActivityViewModel by viewModels()

        supportActionBar?.title = ""


        viewModel.getProduct()
        viewModel.products.observe(this,{
            val products = it
            mAdapter = ProductAdapter(products,this)
            setUpRecyclerview()
        })

    }

    private fun setUpRecyclerview() {

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = mAdapter
        }
    }

    override fun onClick(productId : Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("ID", productId)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_orderer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.order_by_price -> {
                true
            }
            R.id.order_by_category ->{
                true
            }
            R.id.order_by_discount->{
                true
            }
            R.id.order_by_rating->{
                true
            }
            R.id.order_by_stock->{
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}