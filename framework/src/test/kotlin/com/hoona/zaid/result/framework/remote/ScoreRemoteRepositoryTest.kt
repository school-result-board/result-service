package com.hoona.zaid.result.framework.remote

import com.hoona.zaid.result.framework.client.ScoreClient
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ScoreRemoteRepositoryTest {

    lateinit var scoreRemoteRepository: ScoreRemoteRepository
    lateinit var scoreClient: ScoreClient

    @Before
    fun setUp() {
        scoreClient = mock(ScoreClient::class.java)
        scoreRemoteRepository = ScoreRemoteRepository(scoreClient)
    }

    @Test
    fun `should call score service to fetch the score for the student`() {
        val studentId = "1"

        scoreRemoteRepository.getScoresForStudent(studentId)

        verify(scoreClient).getScoresForStudent(studentId)
    }
}
