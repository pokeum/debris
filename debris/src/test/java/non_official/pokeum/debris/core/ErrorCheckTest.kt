package non_official.pokeum.debris.core

import non_official.pokeum.debris.Errors
import non_official.pokeum.debris.Simple
import non_official.pokeum.debris.dsl.debrisApplication
import non_official.pokeum.debris.dsl.module
import org.junit.Ignore
import org.junit.Test

class ErrorCheckTest {

    @Test
    fun `unknown definition`() {
        val app = debrisApplication {
        }

        try {
            app.debris.get<Simple.ComponentA>()
        } catch (e: IllegalStateException) { e.printStackTrace() }

        fail("should not get instance")
    }

    @Test
    fun `unknown linked dependency`() {
        val app = debrisApplication {
            modules(
                module {
                    single { Simple.ComponentB(get()) }
                }
            )
        }

        try {
            app.debris.get<Simple.ComponentB>()
        } catch (e: IllegalStateException) { e.printStackTrace() }

        fail("should not get instance")
    }

   @Test
   fun `error while creating instance`() {
       val app = debrisApplication {
           modules(
               module {
                   single { Errors.Boom() }
               }
           )
       }

       try {
           app.debris.get<Errors.Boom>()
       } catch (e: Exception) { e.printStackTrace() }

       fail("should got InstanceCreationException")
   }

   @Test
   @Ignore
   fun `cycle error`() {
       val app = debrisApplication {
           modules(
               module {
                   single { Errors.CycleA(get()) }
                   single { Errors.CycleB(get()) }
               }
           )
       }

       try {
           app.debris.get<Errors.CycleA>()
       } catch (e: StackOverflowError) {
           e.printStackTrace()
       }

       fail("should break into cycle")
   }

    private fun fail(msg: String) { println("\\\\${"=".repeat(30)} $msg ${"=".repeat(30)}") }
}