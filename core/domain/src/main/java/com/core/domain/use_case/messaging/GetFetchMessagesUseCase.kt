package com.core.domain.use_case.messaging

import com.core.domain.repository.send_message.MessagingRepository
import javax.inject.Inject

class GetFetchMessagesUseCase @Inject constructor(
    private val messagingRepository: MessagingRepository
) {
    suspend operator fun invoke(friendId: String) = messagingRepository.fetchMessages(friendId)
}