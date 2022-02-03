package com.gallor.incomeandexpenses.db.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.gallor.incomeandexpenses.model.Account
import com.gallor.incomeandexpenses.model.Operation

data class AccountWithOperations(
    @Embedded val account: Account,
    @Relation(
        parentColumn = "id",
        entityColumn = "account_id"
    )
    val operations: List<Operation>
)