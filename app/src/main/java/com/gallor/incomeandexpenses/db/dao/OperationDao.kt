package com.gallor.incomeandexpenses.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.gallor.incomeandexpenses.model.Operation
import com.gallor.incomeandexpenses.model.enums.OperationType
import kotlinx.coroutines.flow.Flow

@Dao
abstract class OperationDao : BaseDao<Operation> {
    @Query("SELECT * FROM Operation")
    abstract fun getOperations(): Flow<List<Operation>>

    @Query("SELECT * FROM Operation WHERE type = :type")
    abstract fun getOperationsByType(type: OperationType): Flow<List<Operation>>
}