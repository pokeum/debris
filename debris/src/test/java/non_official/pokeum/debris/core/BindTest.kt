package non_official.pokeum.debris.core

import non_official.pokeum.debris.dsl.binds
import non_official.pokeum.debris.dsl.debrisApplication
import non_official.pokeum.debris.dsl.module
import org.junit.Test
import java.io.Closeable

interface ComponentInterface1: Closeable
interface ComponentInterface2: Closeable
interface ComponentInterface3

class Component1: ComponentInterface1 { override fun close() { println("Component1 - close()") } }
class Component2: ComponentInterface2 { override fun close() { println("Component2 - close()") } }
class Component3: ComponentInterface3 { fun close() { println("Component3 - close()") } }

class BindTest {

    @Test
    fun `simple test`() {
        val app = debrisApplication {
            modules(
                module {
                    single<ComponentInterface1> { Component1() } binds arrayOf(Closeable::class)
                    single<ComponentInterface2> { Component2() } binds arrayOf(Closeable::class)
                    single<ComponentInterface3> { Component3() }
                }
            )
        }

        app.debris.getAll<Closeable>().forEach { it.close() }
    }
}