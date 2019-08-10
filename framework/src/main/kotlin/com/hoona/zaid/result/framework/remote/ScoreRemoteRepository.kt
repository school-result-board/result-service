package com.hoona.zaid.result.framework.remote

import com.hoona.zaid.result.application.repository.ScoreRepository
import com.hoona.zaid.result.domian.Score
import com.hoona.zaid.result.framework.client.ScoreClient
import java.util.*

class ScoreRemoteRepository(private val scoreClient: ScoreClient): ScoreRepository {
    override fun getScoresForStudent(studentId: String): Optional<List<Score>> {
        return scoreClient.getScoresForStudent(studentId)
    }
}
