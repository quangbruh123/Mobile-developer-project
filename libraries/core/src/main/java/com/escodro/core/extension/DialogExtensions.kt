package com.escodro.core.extension

import android.content.Context
import android.content.DialogInterface
import androidx.annotation.ArrayRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun AlertDialog.Builder.items(
    @ArrayRes resArray: Int,
    func: AlertDialog.Builder.(item: Int) -> Unit
) {
    setItems(resArray) { _, item -> func(item) }
}

fun Context.dialog(
    @StringRes titleRes: Int,
    @StringRes message: Int? = null,
    builder: AlertDialog.Builder.() -> Unit
): AlertDialog.Builder =
    AlertDialog.Builder(this).apply {
        setTitle(titleRes)
        message?.let { setMessage(it) }
        builder()
    }

fun AlertDialog.Builder.positiveButton(
    @StringRes resTitle: Int,
    func: AlertDialog.Builder.() -> Unit
) {
    setPositiveButton(resTitle) { _: DialogInterface?, _: Int -> func() }
}

fun AlertDialog.Builder.negativeButton(
    @StringRes resTitle: Int,
    func: AlertDialog.Builder.() -> Unit
) {
    setNegativeButton(resTitle) { _: DialogInterface?, _: Int -> func() }
}

fun AlertDialog.Builder.view(@LayoutRes viewRes: Int) {
    setView(viewRes)
}
