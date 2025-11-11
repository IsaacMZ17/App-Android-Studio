package com.hybridge.pizzaoftheday.domain.usecase

import com.hybridge.pizzaoftheday.domain.model.Pizza
import com.hybridge.pizzaoftheday.domain.repository.PizzaRepository

class GetAllPizzasUseCase(private val repository: PizzaRepository) {
    fun execute(): List<Pizza> = repository.getAllPizzas()
}