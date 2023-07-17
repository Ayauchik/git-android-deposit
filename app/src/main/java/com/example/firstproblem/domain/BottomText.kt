package com.example.firstproblem.domain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp


val testStyle = androidx.compose.ui.text.TextStyle(
    color = Color.Gray,
    fontFamily = FontFamily.Monospace
)

@Composable
fun BottomText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom

    ) {
        Text(
            text = "MADE IN \uD83C\uDDF0\uD83C\uDDFF BY AYAULYM",
            style = testStyle,
            modifier = Modifier.padding(bottom = 10.dp)
        )

    }
}

