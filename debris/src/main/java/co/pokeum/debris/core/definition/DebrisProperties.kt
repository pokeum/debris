package co.pokeum.debris.core.definition

import co.pokeum.debris.core.exception.throwDebrisException
import java.util.concurrent.ConcurrentHashMap

internal class DebrisProperties(private val data: MutableMap<String, Any> = ConcurrentHashMap()) {

    operator fun <T> set(key: String, value: T) { data[key] = value as Any }

    fun contains(key: String): Boolean { return data[key] != null }

    @Suppress("UNCHECKED_CAST")
    operator fun <T> get(key: String): T {
        return data[key] as? T ?: throwDebrisException("missing property for '$key'")
    }

    fun remove(key: String) { data.remove(key) }
}