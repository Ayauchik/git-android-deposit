
package com.example.firstproblem

import android.os.Bundle
import android.transition.Slide
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Slider
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.firstproblem.ui.theme.FirstProblemTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
   // @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ColumnText()
            TextView()
        }
    }
}


@Composable
fun ColumnText() {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color.Black),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text("Депозит", modifier = Modifier.padding(bottom = 10.dp, end = 50.dp))
            Text("23%", modifier = Modifier.padding(bottom = 10.dp, end = 50.dp))
            Text("Комиссия", modifier = Modifier.padding(bottom = 10.dp, end = 50.dp))
            Text("Сумма", modifier = Modifier.padding(bottom = 10.dp, end = 50.dp))
        }
        Column(
            modifier = Modifier.border(width = 1.dp, color = Color.Black).size(150.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            /*
            * val pattern = remember { Regex("^\\d+\$") }

                TextField(
                    value = text,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(pattern)) {
                            text = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            * */

            val enteredText = remember { mutableStateOf("") }
            Box(
              /* modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .size(width = 100.dp, height = 25.dp)*/

            ) {
                TextField(
                    value = enteredText.value,
                    onValueChange = { newEnteredText -> enteredText.value = newEnteredText }
                )
            }

            //Text(text = enteredText.value)

            val sliderPosition = remember { mutableStateOf(0f) }

            Box(
                /*modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(width = 100.dp, height = 25.dp)*/
            ) {
                Slider(
                    value = sliderPosition.value,
                    onValueChange = { newPosition -> sliderPosition.value = newPosition },
                    valueRange = 0f..25f,
                    steps = (25 - 0) / 1 - 1
                )
            }

            //Text(text = "$sliderPosition")



        }
    }
}

val testStyle = androidx.compose.ui.text.TextStyle(
    color = Color.Gray,
    fontFamily = FontFamily.Monospace
)

@Composable
fun TextView() {
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


