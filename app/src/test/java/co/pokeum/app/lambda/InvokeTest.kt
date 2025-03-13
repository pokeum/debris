package co.pokeum.app.lambda

import org.junit.Test

class InvokeTest {

    @Test
    fun main() {
        invokeTest { println("Invoke Test") }
    }

    private fun invokeTest(lambda: () -> Unit) {
        lambda.invoke()
    }
}