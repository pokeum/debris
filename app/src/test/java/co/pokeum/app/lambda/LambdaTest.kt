package co.pokeum.app.lambda

import org.junit.Test

class LambdaTest {

    @Test
    fun main() {
        val builder = Builder(10)
        builder.invokeStuff {
            val result = multiply(1)
            println(result)
        }
    }

    class Builder (private val multiplier: Int) {

        /**
         * T.()
         * it means that in the lambda you will be passing in,
         * "this" (which is the current object) will be type of T.
         */
        fun invokeStuff(action: Builder.() -> Unit) {
            this.action()
        }

        fun multiply (value: Int) : Int {
            return value * multiplier
        }
    }
}