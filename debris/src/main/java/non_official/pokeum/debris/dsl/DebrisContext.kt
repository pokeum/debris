package non_official.pokeum.debris.dsl

import non_official.pokeum.debris.core.DebrisApplication
import non_official.pokeum.debris.core.DebrisContext

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