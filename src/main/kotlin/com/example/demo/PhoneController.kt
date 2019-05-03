package com.example.demo

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@RestController
@RequestMapping("/api/phones")
@Transactional
class PhoneController(private val phoneDao: PhoneDao) {

    @GetMapping
    fun list(): List<Phone> {
        return phoneDao.findAll()
    }

    @GetMapping(params = ["name"])
    fun search(@RequestParam name: String): List<Phone> {
        return phoneDao.findByNameHeyHey(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPhone(@RequestBody command: PhoneCommand): Phone {
        val phone = Phone().apply { name = command.name }
        phoneDao.save(phone)
        return phone
    }

    @GetMapping("/{id}")
    fun getPhone(@PathVariable id: Long): Phone {
        phoneDao.someWeirdMethod()
        return phoneDao.findByIdOrNull(id) ?: throw NotFoundException()
    }
}

data class PhoneCommand(val name: String)
