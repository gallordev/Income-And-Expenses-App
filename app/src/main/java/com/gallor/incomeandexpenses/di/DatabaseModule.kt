package com.gallor.incomeandexpenses.di

import android.content.Context
import androidx.room.Room
import com.gallor.incomeandexpenses.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "income_and_expenses.db"
        ).fallbackToDestructiveMigrationFrom().build()
    }

    @Singleton
    @Provides
    fun provideAccountDao(db: AppDatabase) = db.accountDao()

    @Singleton
    @Provides
    fun provideOperationDao(db: AppDatabase) = db.operationDao()

    @Singleton
    @Provides
    fun provideOperationCategoryDao(db: AppDatabase) = db.categoryDao()
}