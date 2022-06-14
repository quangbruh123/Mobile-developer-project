package com.escodro.core.extension

import android.database.Cursor
import androidx.core.database.getIntOrNull
import androidx.core.database.getLongOrNull
import androidx.core.database.getStringOrNull

fun Cursor.getIntFromColumn(columnName: String): Int? =
    this.getIntOrNull(this.getColumnIndex(columnName))

fun Cursor.getStringFromColumn(columnName: String): String? =
    this.getStringOrNull(this.getColumnIndex(columnName))

fun Cursor.getLongFromColumn(columnName: String): Long? =
    this.getLongOrNull(this.getColumnIndex(columnName))
