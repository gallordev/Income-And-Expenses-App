package com.gallor.incomeandexpenses.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.gallor.incomeandexpenses.db.relationships.AccountWithOperations
import com.gallor.incomeandexpenses.db.relationships.CategoryWithOperations
import com.gallor.incomeandexpenses.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CategoryDao : BaseDao<Category> {
    @Query("SELECT * FROM Category")
    abstract fun getCategories() : Flow<List<Category>>

    @Transaction
    @Query("SELECT * FROM Category WHERE id = :id")
    abstract fun getCategoryWithOperations(id: Int): Flow<CategoryWithOperations>
}