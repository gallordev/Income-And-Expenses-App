package com.gallor.incomeandexpenses.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.gallor.incomeandexpenses.db.relationships.AccountWithOperations
import com.gallor.incomeandexpenses.model.Account
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao : BaseDao<Account> {
    @Query("SELECT * FROM Account")
    abstract fun getAccounts(): Flow<List<Account>>

    @Query("SELECT * FROM Account WHERE id = :id")
    abstract fun getAccountById(id: Int): Account?

    @Transaction
    @Query("SELECT * FROM Account WHERE id = :id")
    abstract fun getAccountWithOperations(id: Int): Flow<AccountWithOperations>
}