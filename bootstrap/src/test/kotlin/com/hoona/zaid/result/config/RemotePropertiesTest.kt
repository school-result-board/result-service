package com.hoona.zaid.result.config

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
class RemotePropertiesTest {

    @Autowired
    lateinit var remoteProperties: RemoteProperties

    @Test
    fun `should initialize score service url`() {
        assertThat(remoteProperties.scoreService.url).isNotEmpty()
    }

    @Test
    fun `should initialize student service url`() {
        assertThat(remoteProperties.studentService.url).isNotEmpty()
    }
}
