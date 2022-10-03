package com.example.pruebamovilbox.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebamovilbox.data.database.entities.ProductEntity

@Dao
interface ProductDao {

    @Query("select * from product_table order by rating desc")
    suspend fun getAllProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ProductEntity)
}