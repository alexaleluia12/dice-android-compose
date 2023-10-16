package com.alexaleluia12.appdado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alexaleluia12.appdado.ui.theme.AppDadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppDadoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

        registerExceptionHandler()
    }

    /**
     * Show debug information if an Runtime erro happen on Compose UI
     */
    private fun registerExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            Log.e("Uncaught exception", e.stackTraceToString())
        }
    }
}

@Composable
fun Greeting(name: String) {
    val mydice = Dice()
    var currentValueDice by remember { mutableStateOf("-") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = currentValueDice, fontSize = 32.sp)
        Button(
            onClick = {
                var newValue = mydice.roll()
                println("novo valor Dado - $newValue")
                currentValueDice = newValue.toString()
            },

            ) {
            Text("ROLL")
        }
    }

}

class Dice(val sides: Int = 6) {

    fun roll(): Int {
        return 10 / (0..4).random()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppDadoTheme {
        Greeting("Android")
    }
}