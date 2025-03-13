package co.pokeum.debris.java

import co.pokeum.debris.core.Debris
import co.pokeum.debris.core.DebrisContext

object DebrisJavaComponent {

    @JvmStatic
    fun <T : Any> inject(clazz: Class<T>): Lazy<T> = lazy(LazyThreadSafetyMode.SYNCHRONIZED) { get(clazz) }

    @JvmStatic
    fun <T : Any> get(clazz: Class<T>): T { return getDebris().get(clazz) }

    /**
     * inject lazily given property
     */
    @JvmStatic
    fun getDebris(): Debris = DebrisContext.get()
}