package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@Component
class Runner(private val phoneService: PhoneService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println(phoneService.listPhonesInUppercase())
    }
}
