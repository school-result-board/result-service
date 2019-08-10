package com.hoona.zaid.result.framework.remote

import com.hoona.zaid.result.application.repository.StudentRepository
import com.hoona.zaid.result.domian.Student
import com.hoona.zaid.result.framework.client.StudentClient
import java.util.*

class StudentRemoteRepository(private val studentClient: StudentClient) : StudentRepository {
    override fun getStudentById(studentId: String): Optional<Student> {
        return studentClient.getStudentById(studentId)
    }
}
