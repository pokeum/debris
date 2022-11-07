package non_official.pokeum.debris.core.definition

object Definitions {

    inline fun <reified T> createSingle(
        noinline definition: Definition<T>,
    ): DebrisDefinition<T> {
        return DebrisDefinition(T::class, definition)
    }
}