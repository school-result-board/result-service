package com.hoona.zaid.result.application.repository

import com.hoona.zaid.result.domian.Student
import java.util.*

interface StudentRepository {
    fun getStudentById(studentId: String): Optional<Student>
}
