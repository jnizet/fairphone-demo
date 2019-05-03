package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@Service
@Transactional
class PhoneService(val phoneDao: PhoneDao,
                   val prefixers: List<Prefixer>) {
    fun listPhonesInUppercase(): List<String> {
        println("# of prefixers: ${prefixers.size}")

        return phoneDao.listPhones().map { prefixers.first().transform(it.toUpperCase()) }
    }

    fun renamePhone(id: Long, newName: String) {
        val phone: PhoneEntity? = phoneDao.getPhone(id)
        if (phone == null) throw NotFoundException()

        if (phone.buyers.size > 0) {
            println("Warning: the phone has already been bought")
        }

        phone.name = newName
    }
}

