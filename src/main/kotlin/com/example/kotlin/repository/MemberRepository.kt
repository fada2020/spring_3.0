package com.example.kotlin.repository

import com.example.kotlin.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository:JpaRepository<Member,Long> {
}