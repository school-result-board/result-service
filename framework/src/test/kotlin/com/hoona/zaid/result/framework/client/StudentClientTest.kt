package com.hoona.zaid.result.framework.client

import com.hoona.zaid.result.domian.Student
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestOperations

class StudentClientTest {

    var studentServiceUrl: String = "http://student-service"
    lateinit var studentClient: StudentClient
    lateinit var restOperations: RestOperations
    @Captor lateinit var urlCaptor: ArgumentCaptor<String>
    @Captor lateinit var httpMethodCaptor: ArgumentCaptor<HttpMethod>
    @Captor lateinit var requestEntityCaptor: ArgumentCaptor<RequestEntity<Any>>
    @Captor lateinit var responseTypeCaptor: ArgumentCaptor<ParameterizedTypeReference<Student>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        restOperations = mock(RestOperations::class.java)
        studentClient = StudentClient(restOperations, studentServiceUrl)
    }

    @Test
    fun `should call student service over http to get student for the given id`() {
        val studentId = "1"
        val expectedStudent = Student("1", "Jason", "Bourne", "UK")
        Mockito.doReturn(ResponseEntity.ok(expectedStudent)).`when`(restOperations)
                .exchange(urlCaptor.capture(), httpMethodCaptor.capture(), requestEntityCaptor.capture(), responseTypeCaptor.capture())

        val student = studentClient.getStudentById(studentId)

        val expectedResponseType: ParameterizedTypeReference<Student> = ParameterizedTypeReference.forType(Student::class.java)
        Assertions.assertThat(urlCaptor.value).isEqualTo("$studentServiceUrl/v1/student/$studentId")
        Assertions.assertThat(httpMethodCaptor.value).isEqualTo(HttpMethod.GET)
        Assertions.assertThat(requestEntityCaptor.value).isNull()
        Assertions.assertThat(responseTypeCaptor.value).isEqualTo(expectedResponseType)
        Assertions.assertThat(student.isPresent).isEqualTo(true)
    }
}
