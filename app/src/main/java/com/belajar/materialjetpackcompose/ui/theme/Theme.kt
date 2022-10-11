package com.belajar.materialjetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(

    background = Cyan900,
    surface = Cyan700,
    onPrimary = White,
    primary = Grey900,
    secondary = Grey100,
    onBackground = Grey100,
    onSurface = White,

)

private val LightColorPalette = lightColors(

    background = Green100,
    surface = Green50,
    onPrimary = Grey900,
    primary = Grey50,
    secondary = Grey700,
    onBackground = Grey100,
    onSurface = Grey900,

)

@Composable
fun MaterialJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}