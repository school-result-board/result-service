package com.hoona.zaid.result

import com.hoona.zaid.result.config.RemoteProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RemoteProperties::class)
class ResultApplication

fun main(args: Array<String>) {
    runApplication<ResultApplication>(*args)
}
