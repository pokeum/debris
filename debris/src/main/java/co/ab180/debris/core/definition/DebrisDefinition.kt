package co.ab180.debris.core.definition

import co.ab180.debris.core.Debris
import kotlin.reflect.KClass

data class DebrisDefinition<T>(
    val primaryType: KClass<*>,
    val definition: Definition<T>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        other as DebrisDefinition<*>
        if (primaryType != other.primaryType) return false

        return true
    }

    override fun hashCode(): Int { return primaryType.hashCode() }

    override fun toString(): String { return "[DebrisDefinition: () -> ${primaryType.simpleName}]" }
}

typealias IndexKey = String
typealias Definition<T> = Debris.() -> T