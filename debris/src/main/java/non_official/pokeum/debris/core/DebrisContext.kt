package non_official.pokeum.debris.core

import non_official.pokeum.debris.core.exception.throwDebrisException
import non_official.pokeum.debris.dsl.DebrisAppDeclaration

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
}