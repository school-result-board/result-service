package com.hoona.zaid.result.config

import com.hoona.zaid.result.application.ResultService
import com.hoona.zaid.result.application.repository.ScoreRepository
import com.hoona.zaid.result.application.repository.StudentRepository
import com.hoona.zaid.result.framework.client.ScoreClient
import com.hoona.zaid.result.framework.client.StudentClient
import com.hoona.zaid.result.framework.remote.ScoreRemoteRepository
import com.hoona.zaid.result.framework.remote.StudentRemoteRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun resultService(scoreRepository: ScoreRepository, studentRepository: StudentRepository): ResultService {
        return ResultService(scoreRepository, studentRepository)
    }

    @Bean
    fun scoreRepository(scoreClient: ScoreClient): ScoreRepository {
        return ScoreRemoteRepository(scoreClient)
    }

    @Bean
    fun studentRepository(studentClient: StudentClient): StudentRepository {
        return StudentRemoteRepository(studentClient)
    }
}
