package com.gallor.incomeandexpenses.di

import com.gallor.incomeandexpenses.db.AppDatabase
import com.gallor.incomeandexpenses.repository.AccountRepository
import com.gallor.incomeandexpenses.repository.AccountRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAccountRepository(db: AppDatabase): AccountRepository = AccountRepositoryImpl(db.accountDao())

}