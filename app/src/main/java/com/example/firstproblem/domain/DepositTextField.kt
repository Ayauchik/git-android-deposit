package com.example.firstproblem.domain

import android.widget.Toast
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun DepositTextField(
    enteredText: String,
    returnedDeposit: (String) -> Unit
) {
    val pattern = remember { Regex("^\\d+\$") }
    val context = LocalContext.current

    TextField(
        value = enteredText,
        modifier = Modifier
            .size(width = 170.dp, height = 48.dp),
        onValueChange = {
            if ((it.isEmpty() || it.matches(pattern)) && it.length<15) {
                returnedDeposit(it)
            }else{
                Toast.makeText(context, "Cannot be entered more", Toast.LENGTH_SHORT).show()
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF6b705c),
            backgroundColor = Color(0xffefebce),
            cursorColor = Color(0xffb7b7a4),
            placeholderColor = Color (0xffffe8d6),
            focusedIndicatorColor = Color(0xFF6b705c)
        )
    )
}

