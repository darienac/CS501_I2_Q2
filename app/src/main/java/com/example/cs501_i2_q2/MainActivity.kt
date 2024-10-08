package com.example.cs501_i2_q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs501_i2_q2.ui.theme.CS501_I2_Q2Theme
import java.util.Calendar
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501_I2_Q2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable fun MainLayout(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var nameCreated by remember {mutableStateOf(false)}
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (nameCreated) {
            Spacer(modifier = Modifier.height(20.dp))
            Label(
                text = "Hello ${name}!"
            )
            Spacer(modifier = Modifier.height(10.dp))
            var hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            var dayGreeting: String?
            if (hour < 12) {
                dayGreeting = "Good morning!"
            } else if (hour < 18) {
                dayGreeting = "Good afternoon!"
            } else if (hour < 21) {
                dayGreeting = "Good evening!"
            } else {
                dayGreeting = "Good night!"
            }
            Label(
                text = dayGreeting
            )
        } else {
            Spacer(modifier = Modifier.height(20.dp))
            Label(
                text = "Greeting Generator"
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(value = name, onValueChange = {name = it}, label = {Text("Enter Name")})
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {nameCreated = true}) {
                Text(text = "Submit Name")
            }
        }
    }
}

@Composable
fun Label(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        color = Color.hsl(120f, 0.5f, 0.4f),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CS501_I2_Q2Theme {
        MainLayout()
    }
}