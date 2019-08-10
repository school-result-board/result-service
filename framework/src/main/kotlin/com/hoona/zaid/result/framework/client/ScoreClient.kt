package com.hoona.zaid.result.framework.client

import com.hoona.zaid.result.domian.Score
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestOperations
import java.util.*

class ScoreClient(private val restOperations: RestOperations, private val scoreServiceUrl: String) {
    fun getScoresForStudent(studentId: String): Optional<List<Score>> {
        val responseType: ParameterizedTypeReference<List<Score>> = object: ParameterizedTypeReference<List<Score>>() {}
        val response = restOperations.exchange("$scoreServiceUrl/v1/score/$studentId", HttpMethod.GET, null, responseType)
        return Optional.ofNullable(response.body)
    }
}
