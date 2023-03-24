package com.example.codingchallenge.viewmodel

import com.example.codingchallenge.model.AcronymRepository
import com.example.codingchallenge.util.CoroutinesTestExtension
import com.example.codingchallenge.util.InstantTaskExecutorExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(InstantTaskExecutorExtension::class)
internal class AcronymViewModelTest {
    private val repo = mockk<AcronymRepository>()
    private val acronymVM = AcronymViewModel(repo)

    @RegisterExtension
    private val extension = CoroutinesTestExtension()

    @Test
    fun getWordsFromAcronym() = runTest(extension.dispatcher) {
        // given
        val initials = "lol"
        val expected = listOf("laugh out loud", "league of legends")
        coEvery { repo.getWordsFromAcronym(initials) } coAnswers { expected }

        // when
        acronymVM.input.value = "lol"
        acronymVM.getWordsFromAcronym()

        // then
        Assertions.assertFalse(acronymVM.state.value?.isLoading ?: true)
        Assertions.assertEquals(expected, acronymVM.state.value?.response)
    }
}
