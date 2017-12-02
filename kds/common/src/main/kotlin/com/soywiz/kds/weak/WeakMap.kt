package com.soywiz.kds.weak

expect class WeakMap<K, V>() {
	operator fun contains(key: K): Boolean
	operator fun set(key: K, value: V): Unit
	operator fun get(key: K): V?
}

fun <K, V> WeakMap<K, V>.getOrPut(key: K, value: (K) -> V): V {
	if (key !in this) this[key] = value(key)
	return this[key]!!
}