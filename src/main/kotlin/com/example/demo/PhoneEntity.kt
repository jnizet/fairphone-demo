package com.example.demo

import javax.persistence.*

@Entity
@Table(name = "phone")
class PhoneEntity {

    @Id
    var id: Long? = null

    lateinit var name: String

    @Column(name = "PHONE_MODEL")
    lateinit var model: String

    @ManyToMany
    @JoinTable(joinColumns = [JoinColumn(name = "PHONE_ID")], inverseJoinColumns = [JoinColumn(name = "BUYER_ID")])
    var buyers: Set<Buyer> = emptySet()
}

@Entity
class Buyer {
    @Id
    var id: Long? = null

    lateinit var firstName: String
    lateinit var lastName: String

    @ManyToMany(mappedBy = "buyers")
    var phones: Set<PhoneEntity> = emptySet()
}

