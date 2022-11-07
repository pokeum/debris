package non_official.pokeum.debris.core.exception

internal inline fun throwDebrisException(message: Any): Nothing {
    throw IllegalStateException("[DEBRIS] $message")
}