package com.hoona.zaid.result.config

import com.hoona.zaid.result.framework.client.ScoreClient
import com.hoona.zaid.result.framework.client.StudentClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate

@Configuration
class RemoteConfig {

    @Bean
    fun restOperations(): RestOperations {
        return RestTemplate()
    }

    @Bean
    fun scoreClient(restOperations: RestOperations, remoteProperties: RemoteProperties): ScoreClient {
        return ScoreClient(restOperations, remoteProperties.scoreService.url)
    }

    @Bean
    fun studentClient(restOperations: RestOperations, remoteProperties: RemoteProperties): StudentClient {
        return StudentClient(restOperations, remoteProperties.studentService.url)
    }
}
