package com.hoona.zaid.result.config

import com.hoona.zaid.result.framework.client.ScoreClient
import com.hoona.zaid.result.framework.client.StudentClient
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
class RemoteConfigTest {
    @Autowired
    lateinit var scoreClient: ScoreClient

    @Autowired
    lateinit var studentClient: StudentClient

    @Test
    fun `should initialize beans`() {
        assertThat(scoreClient).isNotNull()
        assertThat(studentClient).isNotNull()
    }
}
