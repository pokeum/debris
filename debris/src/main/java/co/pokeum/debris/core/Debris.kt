package co.pokeum.debris.core

import co.pokeum.debris.core.definition.DebrisDefinition
import co.pokeum.debris.core.definition.DebrisProperties
import co.pokeum.debris.core.definition.IndexKey
import co.pokeum.debris.core.exception.throwDebrisException
import co.pokeum.debris.core.module.Module
import kotlin.reflect.KClass

class Debris {

    private val properties: DebrisProperties = DebrisProperties()
    private val definitions = HashMap<IndexKey, DebrisDefinition<*>>()

    inline fun <reified T : Any> get(): T { return resolveInstance(T::class) }
    inline fun <reified T : Any> getAll(): List<T> { return getAll(T::class) }

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
        } else { throwDebrisException("'${clazz.qualifiedName}' not found") }
    }

    internal fun loadModules(modules: Iterable<Module>) {
        modules.forEach { module ->
            if (!module.isLoaded) {
                loadModule(module)
            } else { throwDebrisException("module '$module' already loaded!") }
        }
    }

    private fun loadModule(module: Module) {
        declareDebrisDefinitions(module.definitions)
        module.isLoaded = true
    }

    private fun declareDebrisDefinitions(definitions: HashSet<DebrisDefinition<*>>) {
        definitions.forEach { definition -> saveDefinition(definition) }
    }

    private fun saveDefinition(definition: DebrisDefinition<*>) {
        if (definitions.containsValue(definition)) {
            throwDebrisException("Definition '$definition' try to override existing definition.")
        }
        val indexKey: IndexKey = definition.primaryType.qualifiedName ?: ""
        if (indexKey.isNotEmpty()) { definitions[indexKey] = definition }
    }

    internal fun unloadModules(modules: Iterable<Module>) { modules.forEach { unloadModule(it) } }

    private fun unloadModule(module: Module) {
        module.definitions.forEach { definition ->
            val indexKey: IndexKey = definition.primaryType.qualifiedName ?: ""
            properties.remove(indexKey)
            definitions.remove(indexKey)
        }
        module.isLoaded = false
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getAll(clazz: KClass<*>): List<T> {
        val definitions = definitions.values.toSet()
        return definitions
            .filter { definition -> definition.secondaryTypes.contains(clazz) }
            .mapNotNull { get(it.primaryType.java) as T }
    }
}