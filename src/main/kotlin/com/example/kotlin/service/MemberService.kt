package com.example.kotlin.service

import com.example.kotlin.domain.Member
import com.example.kotlin.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun findAll():List<Member>{
        return memberRepository.findAll()
    }
}