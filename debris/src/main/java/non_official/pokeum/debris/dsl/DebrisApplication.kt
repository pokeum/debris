package non_official.pokeum.debris.dsl

import non_official.pokeum.debris.core.DebrisApplication

typealias DebrisAppDeclaration = DebrisApplication.() -> Unit

/**
 * Create a DebrisApplication instance and help configure it
 */
fun debrisApplication(appDeclaration: DebrisAppDeclaration? = null): DebrisApplication {
    val debrisApplication = DebrisApplication.init()
    appDeclaration?.invoke(debrisApplication)
    return debrisApplication
}