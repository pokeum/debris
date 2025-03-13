package co.pokeum.debris.core.exception

internal fun throwDebrisException(message: Any): Nothing {
    throw IllegalStateException("[DEBRIS] $message")
}