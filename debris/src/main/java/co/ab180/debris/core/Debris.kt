package co.ab180.debris.core

import co.ab180.debris.core.definition.DebrisDefinition
import co.ab180.debris.core.definition.DebrisProperties
import co.ab180.debris.core.definition.IndexKey
import co.ab180.debris.core.module.Module
import kotlin.reflect.KClass

class Debris {

    private val properties: DebrisProperties = DebrisProperties()
    private val definitions = HashMap<IndexKey, DebrisDefinition<*>>()

    inline fun <reified T : Any> get(): T { return resolveInstance(T::class) }

    @JvmOverloads
    fun <T : Any> get(clazz: Class<T>): T {
        val kClass = clazz.kotlin
        return resolveInstance(kClass)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> resolveInstance(clazz: KClass<T>): T {

        val indexKey: IndexKey = clazz.qualifiedName ?: ""
        if (indexKey.isNotEmpty() && definitions.containsKey(indexKey)) {
            if (!properties.contains(indexKey)) {
                properties[indexKey] = definitions[indexKey]?.definition?.invoke(this) as T
            }
            return properties[indexKey]
        } else { error("[DEBRIS] '${clazz.qualifiedName}' not found") }
    }

    internal fun loadModules(modules: Iterable<Module>) {
        modules.forEach { module -> declareDebrisDefinitions(module.definitions) }
    }

    private fun declareDebrisDefinitions(definitions: HashSet<DebrisDefinition<*>>) {
        definitions.forEach { definition -> saveDefinition(definition) }
    }

    private fun saveDefinition(definition: DebrisDefinition<*>) {
        if (definitions.containsValue(definition)) {
            error("[DEBRIS] Definition '$definition' try to override existing definition.")
        }
        val indexKey: IndexKey = definition.primaryType.qualifiedName ?: ""
        if (indexKey.isNotEmpty()) { definitions[indexKey] = definition }
    }
}