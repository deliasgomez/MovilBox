package com.example.pruebamovilbox.data.database.daos

import androidx.room.*
import com.example.pruebamovilbox.data.database.entities.ProductEntity


@Dao
interface ProductDao {

    @Query("select * from product_table order by rating desc")
    suspend fun getAllProducts(): List<ProductEntity>

    @Query("select * from product_table order by price desc")
    suspend fun getOrderByPrice(): List<ProductEntity>

    @Query("select * from product_table order by rating desc")
    suspend fun getOrderByRating(): List<ProductEntity>

    @Query("select * from product_table order by category desc")
    suspend fun getOrderByCategory(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ProductEntity)

    @Insert
    suspend fun insertAll(productList: List<ProductEntity>)

    @Query("delete from product_table")
    suspend fun deleteAllProducts()

    @Query("select * from product_table where id = :id ")
    suspend fun getProductById(id:Int):ProductEntity

    @Query("select * from product_table where title like  :query  ")
    suspend fun getProductByQuery(query:String): List<ProductEntity>

}