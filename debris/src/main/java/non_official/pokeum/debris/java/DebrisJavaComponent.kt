package non_official.pokeum.debris.java

import non_official.pokeum.debris.core.Debris
import non_official.pokeum.debris.core.DebrisContext

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