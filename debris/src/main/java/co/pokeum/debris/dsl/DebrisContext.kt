package co.pokeum.debris.dsl

import co.pokeum.debris.core.DebrisApplication
import co.pokeum.debris.core.DebrisContext

/**
 * Start a Debris Application as StandAlone
 */
fun startDebris(appDeclaration: DebrisAppDeclaration): DebrisApplication {
    return DebrisContext.startDebris(appDeclaration)
}

/**
 * Stop current StandAlone Debris application
 */
fun stopDebris() = DebrisContext.stop()