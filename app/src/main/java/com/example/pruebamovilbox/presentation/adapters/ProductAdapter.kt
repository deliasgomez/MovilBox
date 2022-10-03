package com.example.pruebamovilbox.presentation.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pruebamovilbox.R
import com.example.pruebamovilbox.data.model.Product
import com.example.pruebamovilbox.databinding.ItemProductsBinding
import com.example.pruebamovilbox.domain.model.ProductDomain
import com.example.pruebamovilbox.presentation.view.utils.OnClickListener

class ProductAdapter(private var products : List<ProductDomain>,
                     private var listener: OnClickListener
                     ):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ItemProductsBinding.bind(view)
        fun setListener(product: ProductDomain){
            with(binding.root){
                setOnClickListener { listener.onClick(product.id) }

            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products,parent,false)

        return ProductViewHolder(view)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        with(holder){
            setListener(product)
            binding.tvNameProduct.text = product.title
            binding.tvMarkProduct.text = product.mark
            binding.tvProductRating.text = product.rating.toString()
            binding.tvPriceProduct.text = "$ ${product.price}"

            Glide.with(itemView.context)
                .load(product.thumbnail)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivPhotoProduct)


        }
    }

    override fun getItemCount(): Int = products.size

}