package com.example.kotlin.controller

import com.example.kotlin.service.CrawlService
import com.example.kotlin.service.MemberService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
@Controller
class MainController(
    val memberService: MemberService
    , val crawlService: CrawlService
) {
    @GetMapping("/")
    fun main( model:Model):String{
        val findAll = memberService.findAll()
        val findAll2 = memberService.findAll2()
        println("findAll = $findAll")
        println("findAll = $findAll2")
        return "index"
    }
    @GetMapping("/crawling")
    fun crawling(model:Model):String{
        val url:String = "https://www.naver.com/"
        val html = crawlService.getHtml(url)
        println(html)
        if(StringUtils.hasText(html)) {

        }
        return "crawling"
    }
}