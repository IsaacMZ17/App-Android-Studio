package com.hybridge.pizzaoftheday.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PizzaScreen(viewModel: PizzaViewModel = viewModel()) {
    val pizza = viewModel.pizzaState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(WindowInsets.safeDrawing.asPaddingValues()) // Evita el notch y bordes cortados
            .padding(16.dp), // Padding adicional interno
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "🍕 Pizza del día",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD84315),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Card(shape = RoundedCornerShape(12.dp), modifier = Modifier.fillMaxWidth().clickable{
            viewModel.refreshPizza()
        }

            // Acción al hacer click en la card


        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(pizza.type, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Precio: $${pizza.price}", fontSize = 18.sp, color = Color.Gray)
                }

                Image(
                    painter = painterResource(id = pizza.imageRes),
                    contentDescription = pizza.type,
                    modifier = Modifier.size(80.dp)
                )
            }
        }

        Button(
            onClick = { viewModel.refreshPizza() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Cambiar pizza del día")
        }
    }
}