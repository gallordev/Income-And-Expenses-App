package com.gallor.incomeandexpenses.db.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.gallor.incomeandexpenses.model.Category
import com.gallor.incomeandexpenses.model.Operation

data class CategoryWithOperations(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "category_id"
    )
    val operations: List<Operation>
)