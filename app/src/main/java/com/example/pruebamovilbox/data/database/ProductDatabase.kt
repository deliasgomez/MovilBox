package com.example.pruebamovilbox.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebamovilbox.data.database.daos.ProductDao
import com.example.pruebamovilbox.data.database.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao


}