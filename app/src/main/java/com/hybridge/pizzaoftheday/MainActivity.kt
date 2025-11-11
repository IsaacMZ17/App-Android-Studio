package com.hybridge.pizzaoftheday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hybridge.pizzaoftheday.ui.PizzaScreen
import com.hybridge.pizzaoftheday.ui.PizzaViewModel
import com.hybridge.pizzaoftheday.ui.theme.PizzaOfTheDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaOfTheDayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val inner = innerPadding
                    PizzaScreen()
                }
            }
        }
    }
}

//@Composable
//fun PizzaScreen(viewModel: PizzaViewModel = viewModel()) {
//    val pizza = viewModel.pizzaState

//    Column(
//        modifier = Modifier.fillMaxSize().background(Color(color = 0xFFFFF8E1)).padding(WindowInsets.safeDrawing.asPaddingValues())
//    ) {
//        Text(text = "Pizza del dia", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = 0xFFD84315)
//        Alignment.CenterHorizontally
//    }
//}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzaOfTheDayTheme {
        Greeting("Android")
    }
}