package co.ab180.debris.core.logger

class Logger(private val level: Level = Level.INFO) {

    fun v(msg: MESSAGE) { doLog(Level.VERBOSE, msg) }
    fun d(msg: MESSAGE) { doLog(Level.DEBUG, msg) }
    fun i(msg: MESSAGE) { doLog(Level.INFO, msg) }
    fun w(msg: MESSAGE) { doLog(Level.WARN, msg) }
    fun e(msg: MESSAGE) { doLog(Level.ERROR, msg) }
    fun wtf(msg: MESSAGE) { doLog(Level.ASSERT, msg) }

    fun isAt(lvl: Level): Boolean = this.level.index <= lvl.index

    private fun log(level: Level, msg: MESSAGE) { println("[DEBRIS][$level] $msg") }

    private fun canLog(level: Level): Boolean = this.level.index <= level.index

    private fun doLog(level: Level, msg: MESSAGE) { if (canLog(level)) { log(level, msg) } }
}

/**
 * Log Level
 */
enum class Level(val index: Int) {
    VERBOSE(2), DEBUG(3), INFO(4),
    WARN(5), ERROR(6), ASSERT(7)
}

typealias MESSAGE = String