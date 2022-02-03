package com.gallor.incomeandexpenses.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String?,
    @ColumnInfo(name = "created_at") val createdAt: Date,
    @ColumnInfo(name = "updated_at") val updatedAt: Date
)