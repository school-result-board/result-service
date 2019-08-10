package com.hoona.zaid.result.framework.api

import com.hoona.zaid.result.application.ResultService
import com.hoona.zaid.result.domian.Result
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/result")
class ResultController(private val resultService: ResultService) {

    @GetMapping("/{studentId}")
    fun getResultForStudent(@PathVariable("studentId") studentId: String): ResponseEntity<Result> {
        val resultForStudent = resultService.getResultForStudent(studentId)
        return ResponseEntity.ok(resultForStudent)
    }
}
