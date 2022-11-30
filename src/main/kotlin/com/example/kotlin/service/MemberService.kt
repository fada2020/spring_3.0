package com.example.kotlin.service

import com.example.kotlin.domain.Member
import com.example.kotlin.repository.MemberImpl
import com.example.kotlin.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
     val memberRepository: MemberRepository
   ,  val memberImpl: MemberImpl

    ) {
    fun findAll():List<Member>{
        return memberRepository.findAll()
    }
    fun findAll2(): List<Member> {
        return memberImpl.findAll()
    }
}