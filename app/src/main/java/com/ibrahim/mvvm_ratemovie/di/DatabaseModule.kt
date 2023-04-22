package com.ibrahim.mvvm_ratemovie.di

import android.content.Context
import androidx.room.Room
import com.ibrahim.mvvm_ratemovie.data.local.db.AppDatabase
import com.ibrahim.mvvm_ratemovie.data.local.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule() {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext applicationContext:Context): AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java,"movies")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.moviedao()
    }
}