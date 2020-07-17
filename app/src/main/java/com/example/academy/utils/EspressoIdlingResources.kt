package com.example.academy.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResources {
    private const val RESOURCE = "GLOBAL"
    val espressoTestIdlingResources = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResources.increment()
    }

    fun decrement() {
        espressoTestIdlingResources.decrement()
    }
}