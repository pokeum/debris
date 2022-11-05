package co.ab180.debris.core

import co.ab180.debris.core.exception.throwDebrisException
import co.ab180.debris.core.module.Module
import java.util.concurrent.atomic.AtomicBoolean

class DebrisApplication private constructor() {

    val debris = Debris()

    private val isModuleLoaded = AtomicBoolean(false)

    internal fun init() {
    }

    fun modules(modules: Module): DebrisApplication { return modules(listOf(modules)) }

    fun modules(vararg modules: Module): DebrisApplication { return modules(modules.toList()) }

    private fun modules(modules: List<Module>): DebrisApplication {
        if (!isModuleLoaded.getAndSet(true)) {
            debris.loadModules(modules)
            return this
        } else { throwDebrisException("module(s) already loaded!") }
    }

    companion object {

        /**
         * Create a new instance of DebrisApplication
         */
        @JvmStatic
        fun init(): DebrisApplication {
            val app = DebrisApplication()
            app.init()
            return app
        }
    }
}