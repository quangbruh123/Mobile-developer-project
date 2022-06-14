package com.escodro.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = blue700,
    primaryVariant = blue900,
    secondary = blueGray1000,
    onSecondary = blueGray400
)

private val LightColorPalette = lightColors(
    primary = blue700,
    primaryVariant = blue900,
    secondary = blueGray1000,
    onSecondary = blueGray400
)

@Composable
fun TodoListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
