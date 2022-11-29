package com.example.kotlin.controller

import com.example.kotlin.service.MemberService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
@Controller
class MainController(private val memberService: MemberService) {
    @GetMapping("/")
    fun main( model:Model):String{
        val findAll = memberService.findAll()
        val findAll2 = memberService.findAll2()
        println("findAll = $findAll")
        println("findAll = $findAll2")
        return "index";
    }
}