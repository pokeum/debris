package co.ab180.debris.dsl

import co.ab180.debris.core.DebrisApplication

typealias DebrisAppDeclaration = DebrisApplication.() -> Unit

/**
 * Create a DebrisApplication instance and help configure it
 */
fun DebrisApplication(appDeclaration: DebrisAppDeclaration? = null): DebrisApplication {
    val debrisApplication = DebrisApplication.init()
    appDeclaration?.invoke(debrisApplication)
    return debrisApplication
}
