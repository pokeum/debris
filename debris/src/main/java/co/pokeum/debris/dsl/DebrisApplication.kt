package co.pokeum.debris.dsl

import co.pokeum.debris.core.DebrisApplication

typealias DebrisAppDeclaration = DebrisApplication.() -> Unit

/**
 * Create a DebrisApplication instance and help configure it
 */
fun debrisApplication(appDeclaration: DebrisAppDeclaration? = null): DebrisApplication {
    val debrisApplication = DebrisApplication.init()
    appDeclaration?.invoke(debrisApplication)
    return debrisApplication
}