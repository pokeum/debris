package co.pokeum.debris.core

import co.pokeum.debris.core.exception.throwDebrisException
import co.pokeum.debris.core.module.Module
import co.pokeum.debris.dsl.DebrisAppDeclaration

object DebrisContext {

    private var debris: Debris? = null

    /**
     * Get Debris instance
     */
    fun get(): Debris = debris ?: throwDebrisException("DebrisApplication has not been started")

    /**
     * Get Debris instance or null
     */
    fun getOrNull(): Debris? = debris

    /**
     * Start a Debris Application
     */
    fun register(debrisApplication: DebrisApplication) {
        if (debris != null) {
            throwDebrisException("A Debris Application has already been started")
        }
        debris = debrisApplication.debris
    }

    /**
     * Stop current Debris instance
     */
    fun stop() = synchronized(this) { debris = null }

    internal fun startDebris(appDeclaration: DebrisAppDeclaration): DebrisApplication = synchronized(this) {
        val debrisApplication = DebrisApplication.init()
        register(debrisApplication)
        appDeclaration(debrisApplication)
        return debrisApplication
    }

    /**
     * load Koin module in global Koin context
     */
    fun loadKoinModules(module: Module) = synchronized(this) {
        get().loadModules(listOf(module))
    }

    /**
     * load Koin module in global Koin context
     */
    fun loadKoinModules(modules: List<Module>) = synchronized(this) {
        get().loadModules(modules)
    }

    /**
     * unload Koin modules from global Koin context
     */
    internal fun unloadKoinModules(module: Module) = synchronized(this) {
        get().unloadModules(listOf(module))
    }

    /**
     * unload Koin modules from global Koin context
     */
    internal fun unloadKoinModules(modules: List<Module>) = synchronized(this) {
        get().unloadModules(modules)
    }
}