package com.hybridge.pizzaoftheday.domain.repository

import com.hybridge.pizzaoftheday.domain.model.Pizza

interface PizzaRepository {
    fun getPizzaOfTheDay(): Pizza
}