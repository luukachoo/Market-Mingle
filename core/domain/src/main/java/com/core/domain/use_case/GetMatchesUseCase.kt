package com.core.domain.use_case

import com.core.domain.repository.MatchesRepository
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(private val repository: MatchesRepository) {
    suspend operator fun invoke() =
        repository.getRunningMatches()
}