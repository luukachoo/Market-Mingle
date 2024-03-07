package com.core.domain.use_case.auth

import com.core.domain.repository.auth.AuthRepository
import javax.inject.Inject

class GetCheckUserSessionsUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.checkUserSession()
}