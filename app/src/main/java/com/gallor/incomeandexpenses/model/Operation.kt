package com.gallor.incomeandexpenses.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gallor.incomeandexpenses.model.enums.OperationType
import java.util.*

@Entity
data class Operation(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String?,
    val type: OperationType,
    @ColumnInfo(name = "amount_cents") val amountCents: Int,
    @ColumnInfo(name = "account_id") val accountId: Int,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "created_at") val createdAt: Date,
    @ColumnInfo(name = "updated_at") val updatedAt: Date
)