package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@Configuration
class PrefixerConfig {

    @Bean
    fun firstPrefixer(): Prefixer {
        return Prefixer("Hey!")
    }

    @Spanish
    @Bean
    fun secondPrefixer(): Prefixer {
        return Prefixer("hola")
    }
}
