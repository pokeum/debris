package co.pokeum.debris.dsl

import co.pokeum.debris.core.definition.DebrisDefinition
import kotlin.reflect.KClass

/** ================ DebrisDefinition DSL specific functions ================ **/

/**
 * Add a compatible type to match for definition
 * @param clazz
 */
infix fun <T> DebrisDefinition<T>.bind(clazz: KClass<*>): DebrisDefinition<T> {
    secondaryTypes = secondaryTypes + clazz
    return this
}

/**
 * Add a compatible type to match for definition
 */
inline fun <reified T> DebrisDefinition<*>.bind(): DebrisDefinition<*> {
    return bind(T::class)
}

/**
 * Add compatible types to match for definition
 * @param classes
 */
infix fun DebrisDefinition<*>.binds(classes: Array<KClass<*>>): DebrisDefinition<*> {
    secondaryTypes = secondaryTypes + classes
    return this
}