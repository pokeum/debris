package co.pokeum.debris.dsl

import co.pokeum.debris.core.module.Module

typealias ModuleDeclaration = Module.() -> Unit

/**
 * Define a Module
 */
fun module(moduleDeclaration: ModuleDeclaration): Module {
    val module = Module()
    moduleDeclaration(module)
    return module
}