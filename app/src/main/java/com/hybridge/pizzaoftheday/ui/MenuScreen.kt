package com.hybridge.pizzaoftheday.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navController: NavController,
    viewModel: PizzaViewModel = viewModel()
) {
    val pizzas = viewModel.pizzaList

    Scaffold(
        topBar = { TopAppBar(title = { Text("Menú de Pizzas") }) }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(pizzas) { pizza ->
                PizzaItem(pizza = pizza) {
                    navController.navigate("detalle/${pizza.type}")
                }
            }
        }
    }
}