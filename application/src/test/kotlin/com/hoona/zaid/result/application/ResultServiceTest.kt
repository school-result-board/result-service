package com.hoona.zaid.result.application

import com.hoona.zaid.result.application.exception.StudentNotFoundException
import com.hoona.zaid.result.application.repository.ScoreRepository
import com.hoona.zaid.result.application.repository.StudentRepository
import com.hoona.zaid.result.domian.Student
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.util.*

class ResultServiceTest {

    private lateinit var resultService: ResultService
    private lateinit var studentRepository: StudentRepository
    private lateinit var scoreRepository: ScoreRepository

    @Before
    fun setUp() {
        scoreRepository = mock(ScoreRepository::class.java)
        studentRepository = mock(StudentRepository::class.java)
        resultService = ResultService(scoreRepository, studentRepository)
    }

    @Test
    fun `should call student and score repository to get the result for a student`() {
        val studentId = "1"
        val student = Student("1", "1", "1", "1")
        doReturn(Optional.of(student)).`when`(studentRepository).getStudentById(studentId)

        resultService.getResultForStudent(studentId)

        verify(studentRepository).getStudentById(studentId)
        verify(scoreRepository).getScoresForStudent(studentId)
    }

    @Test(expected = StudentNotFoundException::class)
    fun `should throw exception when student is not found`() {
        val studentId = "1"

        resultService.getResultForStudent(studentId)

        verify(studentRepository).getStudentById(studentId)
        verify(scoreRepository).getScoresForStudent(studentId)
    }
}
