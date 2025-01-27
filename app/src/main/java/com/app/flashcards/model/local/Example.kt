package com.app.flashcards.model.local

import android.view.Gravity

sealed class Example

data class ExampleMath(
    val cosinus: String,
    val sinus: String
) : Example()

data class ExampleCosmos(
    val gravitation: Gravity,
    val vacuum: Any
) : Example()

object ExampleNone : Example()

class Ex {
    private val ex: Example = ExampleNone

    fun smth() {
        when(ex) {
            is ExampleCosmos -> TODO()
            is ExampleMath -> TODO()
            is ExampleNone -> TODO()
        }
    }
}
