package com.example.kotlin.service

import org.springframework.http.HttpHeaders
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import java.util.function.Consumer

@Service
class CrawlService {

    val exchangeStrategies = ExchangeStrategies.builder()
        .codecs { configurer: ClientCodecConfigurer ->
            configurer.defaultCodecs().maxInMemorySize(-1)
        } // to unlimited memory size
        .build()

    fun getHeaders(): Consumer<HttpHeaders> {
        return Consumer { httpHeaders: HttpHeaders ->
            httpHeaders.add(
                "Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
            )
            httpHeaders.add("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
            httpHeaders.add("Cache-Control", "max-age=0")
            httpHeaders.add("Connection", "keep-alive")
            httpHeaders.add(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36"
            )
            httpHeaders.add("referer", "https://product.kyobobook.co.kr/bestseller/online?period=001")
        }
    }

    fun getWebClient(url:String):WebClient{
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeaders(getHeaders())
            .exchangeStrategies(exchangeStrategies)
            .build();
    }

    fun getHtml(url: String): String? {
        return getWebClient(url)
            .get()
            .retrieve()
            .bodyToMono<String>(String::class.java)
            .block()
    }
}