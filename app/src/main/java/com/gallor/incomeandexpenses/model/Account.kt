package com.gallor.incomeandexpenses.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String?,
    @Embedded val currency: Currency,
    val balance: Int,
    @ColumnInfo(name = "created_at") val createdAt: Date = Date(),
    @ColumnInfo(name = "updated_at") val updatedAt: Date = Date()
)