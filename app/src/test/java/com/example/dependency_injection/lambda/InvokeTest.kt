package com.example.dependency_injection.lambda

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