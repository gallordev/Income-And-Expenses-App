package com.gallor.incomeandexpenses.db

import androidx.room.TypeConverter
import com.gallor.incomeandexpenses.model.enums.OperationType
import java.util.*

object Converters {
    // TypeConverter: OperationType <==> String
    @TypeConverter
    @JvmStatic
    fun operationTypeToString(value: OperationType) = value.name

    @TypeConverter
    @JvmStatic
    fun stringToOperationType(value: String) = enumValueOf<OperationType>(value)

    // TypeConverter: Long <==> Date
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}