package com.example.pruebamovilbox.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebamovilbox.R
import com.example.pruebamovilbox.databinding.ActivityMainBinding
import com.example.pruebamovilbox.presentation.adapters.ProductAdapter
import com.example.pruebamovilbox.presentation.view.utils.OnClickListener
import com.example.pruebamovilbox.presentation.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickListener , SearchView.OnQueryTextListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mAdapter: ProductAdapter
    private val viewModel : MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = ""
        viewModel.getProduct()
        productObserver()

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
        val item = menu.findItem(R.id.search)
        val searchView = item?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)


        return true

    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null ){
            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String): Boolean {
        if (query != null){
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query : String){
        val searchQuery = "%$query%"
        viewModel.getProductByQuery(searchQuery)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.order_by_price -> {
                viewModel.getOrderByPrice()
                true
            }
            R.id.order_by_category ->{
                viewModel.getOrderByCategory()
                true
            }

            R.id.order_by_rating->{
                viewModel.getOrderByRating()

                true
            }


            else -> super.onOptionsItemSelected(item)
        }


    }
    private fun productObserver(){
        viewModel.products.observe(this,{
            val products = it
            mAdapter = ProductAdapter(products,this)
            setUpRecyclerview()

        })
    }



}