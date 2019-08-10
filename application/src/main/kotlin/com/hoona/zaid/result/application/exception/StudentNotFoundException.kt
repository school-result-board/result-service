package com.hoona.zaid.result.application.exception

class StudentNotFoundException(studentId: String): Exception("Cannot find student with id $studentId")
