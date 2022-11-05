package co.ab180.debris.core.exception

internal inline fun throwDebrisException(message: Any): Nothing {
    throw IllegalStateException("[DEBRIS] $message")
}