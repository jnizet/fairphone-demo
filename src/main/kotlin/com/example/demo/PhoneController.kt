package com.example.demo

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@RestController
@RequestMapping("/api/phones") // http://localhost:8080/api/phones?name=foo
@Transactional
class PhoneController(private val phoneService: PhoneService) {

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun searchPhones(@RequestParam("name") name: String?): List<Phone> {
        println("name = $name")
        val result = listOf(Phone(1, "Fairphone", "1.0"), Phone(2, "Fairphone", "2.0"))

        return result;
    }

    @GetMapping("/{id}") // http://localhost:8080/api/phones/1
    fun getPhone(@PathVariable("id") id: Long): PhoneEntity {
        if (id > 10) {
            throw NotFoundException()
        }

        return Phone(entity.id, entity.name, entity.model)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPhone(@Validated @RequestBody command: PhoneCommand): Phone {
        return Phone(42, command.name, command.model)
    }
}

data class PhoneCommand(
    @JsonProperty("theName") val name: String,
    @field:Length(min = 4) val model: String
)

data class Phone(
    val id: Long,
    @JsonProperty("theName") val theName: String,
    val model: String
)
