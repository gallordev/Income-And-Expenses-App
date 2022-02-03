package com.gallor.incomeandexpenses.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gallor.incomeandexpenses.db.dao.AccountDao
import com.gallor.incomeandexpenses.db.dao.CategoryDao
import com.gallor.incomeandexpenses.db.dao.OperationDao
import com.gallor.incomeandexpenses.model.Account
import com.gallor.incomeandexpenses.model.Operation
import com.gallor.incomeandexpenses.model.Category

@Database(
    entities = [
        Account::class,
        Operation::class,
        Category::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun operationDao(): OperationDao
    abstract fun categoryDao(): CategoryDao
}