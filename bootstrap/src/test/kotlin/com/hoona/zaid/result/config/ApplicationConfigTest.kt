package com.hoona.zaid.result.config

import com.hoona.zaid.result.application.ResultService
import com.hoona.zaid.result.application.repository.ScoreRepository
import com.hoona.zaid.result.application.repository.StudentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("test")
class ApplicationConfigTest {

    @Autowired
    lateinit var resultService: ResultService

    @Autowired
    lateinit var scoreRepository: ScoreRepository

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Test
    fun `should configure bean`() {
        assertThat(resultService).isNotNull
        assertThat(scoreRepository).isNotNull
        assertThat(studentRepository).isNotNull
    }
}
