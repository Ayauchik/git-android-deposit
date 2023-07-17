package com.example.firstproblem.domain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DepositSlider(
    sliderPosition: Float,
    returnedPosition: (Float) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = returnedPosition,
            valueRange = 0f..25f,
            modifier = Modifier.size(width = 180.dp, height = 50.dp),
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF6b705c),
                activeTickColor = Color(0xffa5a58d),
                activeTrackColor = Color(0xffb7b7a4),
            )
        )

        val depositType = when (sliderPosition.toLong()) {
            in 0..9 -> {
                Text(
                    "Пенсионный",
                    style = TextStyle(
                        color = Color(0xff006466),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
            }

            in 10..14 -> {
                Text(
                    "Оптимальный",
                    style = TextStyle(
                        color = Color(0xff00509d),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            in 15..19 -> {
                Text(
                    "Комфорт",
                    style = TextStyle(
                        color = Color(0xff245501),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            in 20..24 -> {
                Text(
                    "Бизнесмен",
                    style = TextStyle(
                        color = Color(0xff3c096c),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            else -> {
                Text(
                    "Максимум",
                    style = TextStyle(
                        color = Color(0xff800e13),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }

        return depositType
    }

}