package com.hoona.zaid.result.framework.client

import com.hoona.zaid.result.domian.Score
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestOperations

class ScoreClientTest {

    private var scoreServiceUrl: String = "http://score-service"
    lateinit var scoreClient: ScoreClient
    lateinit var restOperations: RestOperations
    @Captor lateinit var urlCaptor: ArgumentCaptor<String>
    @Captor lateinit var httpMethodCaptor: ArgumentCaptor<HttpMethod>
    @Captor lateinit var requestEntityCaptor: ArgumentCaptor<RequestEntity<Any>>
    @Captor lateinit var responseTypeCaptor: ArgumentCaptor<ParameterizedTypeReference<List<Score>>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        restOperations = mock(RestOperations::class.java)
        scoreClient = ScoreClient(restOperations, scoreServiceUrl)
    }

    @Test
    fun `score client should call score service over http to fetch score for a student`() {
        val studentId = "1"
        val expectedScore = Score("1", "Jason", 1, 1, 1, 1 ,1, 1)
        doReturn(ResponseEntity.ok(expectedScore)).`when`(restOperations)
                .exchange(urlCaptor.capture(), httpMethodCaptor.capture(), requestEntityCaptor.capture(), responseTypeCaptor.capture())

        val scores = scoreClient.getScoresForStudent(studentId)

        val expectedResponseType: ParameterizedTypeReference<List<Score>> = object: ParameterizedTypeReference<List<Score>>() {}
        assertThat(urlCaptor.value).isEqualTo("$scoreServiceUrl/v1/score/$studentId")
        assertThat(httpMethodCaptor.value).isEqualTo(HttpMethod.GET)
        assertThat(requestEntityCaptor.value).isNull()
        assertThat(responseTypeCaptor.value).isEqualTo(expectedResponseType)
        assertThat(scores.isPresent).isEqualTo(true)
    }
}
