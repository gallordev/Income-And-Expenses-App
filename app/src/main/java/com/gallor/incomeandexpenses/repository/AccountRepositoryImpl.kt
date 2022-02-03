package com.gallor.incomeandexpenses.repository

import com.gallor.incomeandexpenses.db.dao.AccountDao
import com.gallor.incomeandexpenses.model.Account
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val dao: AccountDao
) : AccountRepository {
    override suspend fun insertAccount(account: Account) {
        dao.insert(account)
    }

    override suspend fun updateAccount(account: Account) {
        dao.update(account)
    }

    override suspend fun deleteAccount(account: Account) {
        dao.delete(account)
    }

    override suspend fun getAccountById(accountId: Int) = dao.getAccountById(accountId)

    override fun getAccounts() = dao.getAccounts()
}