package com.example.firstproblem.domain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstproblem.R
import com.example.firstproblem.ui.theme.getKav
import kotlin.math.roundToLong

@Composable
fun CenterText() {

    var enteredText by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableStateOf(0f) }
    var calculationResult by remember { mutableStateOf(0L) }

    LaunchedEffect(enteredText, sliderPosition) {
        val intValue = enteredText.toLongOrNull() ?: 0L
        val result = intValue * sliderPosition.roundToLong() / 100L
        calculationResult = result
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        FirstColumn(sliderPosition)
        SecondColumn(
            enteredText = enteredText,
            sliderPosition = sliderPosition,
            calculationResult = calculationResult,
            onEnteredTextChange = { enteredText = it },
            onSliderPositionChange = { sliderPosition = it }
        )
    }
}

@Composable
fun FirstColumn(
    sliderPosition: Float
) {
    Column(
        modifier = Modifier
            .size(width = 200.dp, height = 248.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End
    ) {

        val clmnColor = colorResource(id = R.color.numsCol1)
        //val clmnFontSize = dimensionResource(id = R.dimen.myFontSize)
        val colText = TextStyle(color = clmnColor, fontSize = 20.sp, fontWeight = FontWeight.W500)

        Text(
            "Депозит", modifier = Modifier.padding(bottom = 8.dp, end = 48.dp, top = 20.dp),
            style = colText
        )
        Text(
            text = "${sliderPosition.roundToLong()}%",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp, top = 20.dp),
            style = colText
        )
        Text(
            text = "Комиссия",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp, top = 20.dp),
            style = colText
        )
        Text(
            "Сумма",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp),
            style = colText,
            fontWeight = FontWeight.W800,
            fontFamily = getKav(),
            fontSize = 24.sp,
        )
    }
}

@Composable
fun SecondColumn(
    enteredText: String,
    sliderPosition: Float,
    calculationResult: Long,
    onEnteredTextChange: (String) -> Unit,
    onSliderPositionChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier
            .size(width = 200.dp, height = 248.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DepositTextField(enteredText = enteredText, returnedDeposit = onEnteredTextChange)
        DepositSlider(sliderPosition = sliderPosition, returnedPosition = onSliderPositionChange)

        Text(
            text = "$calculationResult",
            fontSize = 20.sp,
            color = colorResource(id = R.color.numsCol2)
        )
        Text(
            text = "${calculationResult + (enteredText.toLongOrNull() ?: 0)}",
            fontSize = 20.sp,
            color = colorResource(id = R.color.numsCol2),
            fontWeight = FontWeight.W800,
            fontFamily = getKav(),
        )
    }
}


/*

var enteredText by mutableStateOf("")
var sliderPosition by mutableStateOf(0f)

@Composable
fun CenterText() {

    var calculationResult by remember { mutableStateOf(0L) }

    LaunchedEffect(enteredText, sliderPosition) {
        val intValue = enteredText.toLongOrNull() ?: 0
        val result = intValue * sliderPosition.roundToLong() / 100
        calculationResult = result
    }

    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        FirstColumn()
        SecondColumn(calculationResult = calculationResult)
    }
}

@Composable
fun FirstColumn() {
    Column(
        modifier = Modifier
            .size(width = 200.dp, height = 248.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End
    ) {

        val clmnColor = colorResource(id = R.color.col_1)
        //val clmnFontSize = dimensionResource(id = R.dimen.myFontSize)
        val colText = TextStyle(color = clmnColor, fontSize = 20.sp, fontWeight = FontWeight.W500)

        Text("Депозит",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp, top = 20.dp),style = colText
        )

        Text(
            text = "${sliderPosition.roundToLong()}%",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp, top = 20.dp), style = colText
        )

        Text(
            text = "Комиссия",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp, top = 20.dp), style = colText
        )

        Text(
            "Сумма",
            modifier = Modifier.padding(bottom = 8.dp, end = 48.dp), style = colText,
            fontWeight = FontWeight.W800
        )
    }
}



@Composable
fun SecondColumn(calculationResult: Long) {
    Column(
        modifier = Modifier
            .size(width = 200.dp, height = 248.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DepositTextField(enteredText = enteredText, returnedDeposit = { enteredText = it })
        DepositSlider( sliderPosition = sliderPosition, returnedPosition = {sliderPosition = it})

        Text(
            text = "$calculationResult",
            fontSize = 20.sp,
            color = colorResource(id = R.color.nums)
        )

        Text(
            text = "${calculationResult.plus(enteredText.toLongOrNull() ?: 0)}",
            fontSize = 20.sp,
            color = colorResource(id = R.color.nums),
            fontWeight = FontWeight.W800
        )
    }
}*/
