package com.example.firstproblem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firstproblem.domain.BottomText
import com.example.firstproblem.domain.CenterText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CenterText()
            BottomText()
        }
    }
}











