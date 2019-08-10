package com.hoona.zaid.result.framework.remote

import com.hoona.zaid.result.framework.client.StudentClient
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class StudentRemoteRepositoryTest {

    lateinit var studentClient: StudentClient
    lateinit var studentRemoteRepository: StudentRemoteRepository

    @Before
    fun setUp() {
        studentClient = mock(StudentClient::class.java)
        studentRemoteRepository = StudentRemoteRepository(studentClient)
    }

    @Test
    fun `should call student client to get the details for student`() {
        val studentId = "1"

        studentRemoteRepository.getStudentById(studentId)

        verify(studentClient).getStudentById(studentId)
    }
}
