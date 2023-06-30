package com.example.dependency_injection.koin

import org.junit.Assert
import org.junit.Test
import org.koin.dsl.binds
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import java.io.Closeable

interface ComponentInterface1: Closeable
interface ComponentInterface2: Closeable
interface ComponentInterface3

class Component1: ComponentInterface1 { override fun close() { println("Component1 - close()") } }
class Component2: ComponentInterface2 { override fun close() { println("Component2 - close()") } }
class Component3: ComponentInterface3 { fun close() { println("Component3 - close()") } }

class BindTest {

    @Test
    fun `koin bind test - success`() {
        val app = koinApplication {
            modules(
                module {
                    single<ComponentInterface1> { Component1() } binds arrayOf(Closeable::class)
                    single<ComponentInterface2> { Component2() } binds arrayOf(Closeable::class)
                    single<ComponentInterface3> { Component3() }
                }
            )
        }

        app.koin.getAll<Closeable>().forEach { it.close() }
    }

    @Test
    fun `koin bind test - fail`() {
        val app = koinApplication {
            modules(
                module {
                    single<ComponentInterface1> { Component1() } binds arrayOf(Closeable::class)
                    single<ComponentInterface2> { Component2() } binds arrayOf(Closeable::class)
                    single<ComponentInterface3> { Component3() } binds arrayOf(Closeable::class)
                }
            )
        }

        val exception: Exception = Assert.assertThrows(ClassCastException::class.java) {
            app.koin.getAll<Closeable>().forEach { it.close() }
        }
        print("[Exception] ${exception.message}")
    }
}