package com.hoona.zaid.result.framework.api

import com.hoona.zaid.result.application.ResultService
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ResultControllerTest {

    lateinit var resultController: ResultController
    lateinit var resultService: ResultService

    @Before
    fun setUp() {
        resultService = mock(ResultService::class.java)
        resultController = ResultController(resultService)
    }

    @Test
    fun `should call result service to get the result for student`() {
        val studentId = "1"

        resultController.getResultForStudent(studentId)

        verify(resultService).getResultForStudent(studentId)
    }
}
