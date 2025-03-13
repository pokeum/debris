package co.pokeum.debris.core.module

import co.pokeum.debris.core.definition.DebrisDefinition
import co.pokeum.debris.core.definition.Definition
import co.pokeum.debris.core.definition.Definitions
import co.pokeum.debris.core.exception.throwDebrisException

class Module {

    // [@PublishedApi] https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-published-api/
    @PublishedApi
    internal var isLoaded: Boolean = false
    @PublishedApi
    internal val definitions = hashSetOf<DebrisDefinition<*>>()

    inline fun <reified T> single(
        noinline definition: Definition<T>
    ): DebrisDefinition<T> {
        val def = Definitions.createSingle(definition)
        definitions.addDefinition(def)
        return def
    }
}

fun HashSet<DebrisDefinition<*>>.addDefinition(definition : DebrisDefinition<*>) {
    val added = add(definition)
    if (!added) { throwDebrisException("Definition '$definition' try to override existing definition.") }
}