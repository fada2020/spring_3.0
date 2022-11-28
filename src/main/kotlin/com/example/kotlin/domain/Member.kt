package com.example.kotlin.domain

import jakarta.persistence.*

@Entity
open class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "age", nullable = false)
    open var age: String? = null
}