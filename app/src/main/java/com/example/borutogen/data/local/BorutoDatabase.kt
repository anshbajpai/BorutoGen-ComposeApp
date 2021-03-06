package com.example.borutogen.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.borutogen.data.local.dao.HeroDao
import com.example.borutogen.data.local.dao.HeroRemoteKeyDao
import com.example.borutogen.domain.model.Hero
import com.example.borutogen.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 2)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}