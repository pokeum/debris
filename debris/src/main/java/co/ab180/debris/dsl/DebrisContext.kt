package co.ab180.debris.dsl

import co.ab180.debris.core.DebrisApplication
import co.ab180.debris.core.DebrisContext

/**
 * Start a Debris Application as StandAlone
 */
fun startDebris(appDeclaration: DebrisAppDeclaration): DebrisApplication {
    return DebrisContext.startDebris(appDeclaration)
}