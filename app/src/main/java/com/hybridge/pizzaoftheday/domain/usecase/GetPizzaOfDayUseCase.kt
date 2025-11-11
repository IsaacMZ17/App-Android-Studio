package com.hybridge.pizzaoftheday.domain.usecase

import com.hybridge.pizzaoftheday.domain.model.Pizza
import com.hybridge.pizzaoftheday.domain.repository.PizzaRepository

class GetPizzaOfDayUseCase(private val repository: PizzaRepository) {
    fun execute(): Pizza {
        val pizza = repository.getPizzaOfTheDay()
        val discounted = pizza.price * 0.9
        return pizza.copy(price = discounted)
    }
}