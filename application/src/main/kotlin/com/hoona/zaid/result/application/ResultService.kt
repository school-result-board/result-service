package com.hoona.zaid.result.application

import com.hoona.zaid.result.application.exception.StudentNotFoundException
import com.hoona.zaid.result.application.repository.ScoreRepository
import com.hoona.zaid.result.application.repository.StudentRepository
import com.hoona.zaid.result.domian.Result

class ResultService(private val scoreRepository: ScoreRepository, private val studentRepository: StudentRepository) {

    fun getResultForStudent(studentId: String): Result {
        val optionalStudent = studentRepository.getStudentById(studentId)
        val optionalScores = scoreRepository.getScoresForStudent(studentId)

        val student = optionalStudent.orElseThrow { StudentNotFoundException(studentId) }
        val scores = optionalScores.orElseGet { emptyList() }

        return Result(student, scores)
    }
}
