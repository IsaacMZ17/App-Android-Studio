package com.hybridge.pizzaoftheday.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hybridge.pizzaoftheday.data.repository.PizzaRepositoryImpl
import com.hybridge.pizzaoftheday.domain.usecase.GetPizzaOfDayUseCase

class PizzaViewModel : ViewModel() {

    private val getPizzaUseCase = GetPizzaOfDayUseCase(PizzaRepositoryImpl())

    // mutableStateOf con delegación 'by'
    var pizzaState by mutableStateOf(getPizzaUseCase.execute())
        private set

    fun refreshPizza() {
        pizzaState = getPizzaUseCase.execute()
    }
}