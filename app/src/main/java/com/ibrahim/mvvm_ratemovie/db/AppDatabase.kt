package com.ibrahim.mvvm_ratemovie.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahim.mvvm_ratemovie.db.dao.MovieDao
import com.ibrahim.mvvm_ratemovie.db.entity.MovieEntity


@Database(entities = [MovieEntity::class],version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun moviedao(): MovieDao

}
/*
AppDatabase class’ı DB’yi temsil eder ve SQLite DB ile bağlantı kurar.
Abstract sınıf olan RoomDatabase() sınıfından extend edilmesi gerekir.
@Database ile oluşan veritabanın tüm sınıflara erişmesinin listesini alır ve
veritabanın versiyonun belirtilmesi gerekir.
Eğer veritabanında bir genişletme veya değişiklik yapıldığı taktirde bu versiyon
kodunda değişiklik yapılması gerekir.
*/
