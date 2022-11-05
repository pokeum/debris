package co.ab180.debris.core

import co.ab180.debris.dsl.DebrisAppDeclaration

object DebrisContext {

    private var debris: Debris? = null

    /**
     * Get Debris instance
     */
    fun get(): Debris = debris ?: error("[DEBRIS] DebrisApplication has not been started")

    /**
     * Get Debris instance or null
     */
    fun getOrNull(): Debris? = debris

    /**
     * Start a Debris Application
     */
    fun register(debrisApplication: DebrisApplication) {
        if (debris != null) {
            throw IllegalStateException("[DEBRIS] A Debris Application has already been started")
        }
        debris = debrisApplication.debris
    }

    fun startDebris(appDeclaration: DebrisAppDeclaration): DebrisApplication = synchronized(this) {
        val debrisApplication = DebrisApplication.init()
        register(debrisApplication)
        appDeclaration(debrisApplication)
        return debrisApplication
    }
}