package co.ab180.debris.java

import co.ab180.debris.core.Debris
import co.ab180.debris.core.DebrisContext

object DebrisJavaComponent {

    @JvmOverloads
    @JvmStatic
    fun <T : Any> inject(clazz: Class<T>): Lazy<T> = lazy(LazyThreadSafetyMode.SYNCHRONIZED) { get(clazz) }

    @JvmOverloads
    @JvmStatic
    fun <T : Any> get(clazz: Class<T>): T { return getDebris().get(clazz) }

    /**
     * inject lazily given property
     */
    @JvmStatic
    fun getDebris(): Debris = DebrisContext.get()
}