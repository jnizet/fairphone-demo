package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
interface PhoneDao : JpaRepository<Phone, Long>, PhoneDaoCustom {

    @Query("select phone from Phone phone where name = :name order by phone.id desc")
    fun findByNameHeyHey(@Param("name") name: String): List<Phone>
}


