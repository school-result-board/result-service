package com.hoona.zaid.result.application.repository

import com.hoona.zaid.result.domian.Score
import java.util.*

interface ScoreRepository {
    fun getScoresForStudent(studentId: String): Optional<List<Score>>
}
