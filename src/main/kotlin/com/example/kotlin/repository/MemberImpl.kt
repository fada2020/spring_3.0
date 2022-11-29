package com.example.kotlin.repository

import com.example.kotlin.domain.Member
import com.example.kotlin.domain.QMember
import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MemberImpl(val jpaQueryFactory: JPAQueryFactory) {

    fun findAll(): List<Member> {
        val builder = BooleanBuilder()
        val member:QMember = QMember.member;
        return jpaQueryFactory.selectFrom(member).fetch();
    }

}