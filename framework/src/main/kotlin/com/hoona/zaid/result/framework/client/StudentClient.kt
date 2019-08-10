package com.hoona.zaid.result.framework.client

import com.hoona.zaid.result.domian.Student
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestOperations
import java.util.*

class StudentClient(private val restOperations: RestOperations, private val studentServiceUrl: String) {
    fun getStudentById(studentId: String): Optional<Student> {
        val responseType: ParameterizedTypeReference<Student> = ParameterizedTypeReference.forType(Student::class.java)
        val response = restOperations.exchange("$studentServiceUrl/v1/student/$studentId", HttpMethod.GET, null, responseType)
        return Optional.ofNullable(response.body)
    }
}
