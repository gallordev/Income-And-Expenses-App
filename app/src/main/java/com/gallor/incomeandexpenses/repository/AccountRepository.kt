package com.gallor.incomeandexpenses.repository

import com.gallor.incomeandexpenses.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun insertAccount(account: Account)
    suspend fun updateAccount(account: Account)
    suspend fun deleteAccount(account: Account)
    suspend fun getAccountById(accountId: Int): Account?
    fun getAccounts(): Flow<List<Account>>
}