package com.example.demo

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@Repository
class PhoneDao(var em: EntityManager) {

    fun listPhones(): List<String> {
        return listOf("FairPhone 1", "FairPhone 2")
    }

    @Transactional
    fun getPhone(id: Long): PhoneEntity? {
        val phone = em.find(PhoneEntity::class.java, id)
        return phone
    }

    fun findAll(name: String): List<PhoneEntity> {
        return em.createQuery("select p from PhoneEntity p where p.name = :name", PhoneEntity::class.java)
            .setParameter("name", name)
            .resultList
    }
}
