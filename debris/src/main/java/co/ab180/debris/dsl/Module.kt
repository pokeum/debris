package co.ab180.debris.dsl

import co.ab180.debris.core.module.Module

typealias ModuleDeclaration = Module.() -> Unit

/**
 * Define a Module
 */
fun module(moduleDeclaration: ModuleDeclaration): Module {
    val module = Module()
    moduleDeclaration(module)
    return module
}