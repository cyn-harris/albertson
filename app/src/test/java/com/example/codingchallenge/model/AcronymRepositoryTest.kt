package com.example.codingchallenge.model

import com.example.codingchallenge.model.dto.Lf
import com.example.codingchallenge.model.dto.ShortForResponseItem
import com.example.codingchallenge.model.remote.AcronymService
import com.example.codingchallenge.util.CoroutinesTestExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalCoroutinesApi::class)
internal class AcronymRepositoryTest {
    private val service = mockk<AcronymService>()
    private val repo = AcronymRepository(service)

    @RegisterExtension
    private val extension = CoroutinesTestExtension()

    @Test
    @DisplayName("Test fetching the list of long-form phrases for a given acronym")
    fun getWordsFromAcronym() = runTest(extension.dispatcher) {
        // given
        val initials = "lol"
        val expected = "laugh out loud"
        val result = arrayListOf(
            ShortForResponseItem(listOf(Lf(lf = expected)), "lol")
        )
        coEvery { service.getWordFromAcronym(initials).isSuccessful } coAnswers { true }
        coEvery { service.getWordFromAcronym(initials).body() } coAnswers { result }

        // when
        val actual = repo.getWordsFromAcronym(initials)

        // then
        Assertions.assertEquals(expected, actual[0])
    }
}
