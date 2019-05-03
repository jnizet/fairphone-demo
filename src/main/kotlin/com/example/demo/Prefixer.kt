package com.example.demo

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
class Prefixer(private var prefix: String) {
    fun transform(s: String): String {
        return "$prefix $s"
    }
}
