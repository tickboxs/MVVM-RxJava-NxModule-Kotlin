package com.tickboxs.base.common

typealias Supplier<T> = () -> T

interface Consumer<T> {

    fun accept(t: T)
}