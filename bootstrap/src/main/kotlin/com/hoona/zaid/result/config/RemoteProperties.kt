package com.hoona.zaid.result.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "school-result-board")
class RemoteProperties {
    val scoreService = RemoteServiceProperties()
    val studentService = RemoteServiceProperties()

    data class RemoteServiceProperties(var url: String = "")
}
