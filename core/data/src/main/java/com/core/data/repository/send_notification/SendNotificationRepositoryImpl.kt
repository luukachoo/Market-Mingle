package com.core.data.repository.send_notification

import com.core.common.mapper.asResource
import com.core.common.resource.Resource
import com.core.common.resource.retrofit.HandleRetrofitResponse
import com.core.data.mapper.send_notification.toDomain
import com.core.data.model.send_notification.NotificationDataDTO
import com.core.data.model.send_notification.NotificationPayloadDTO
import com.core.data.service.send_notification.SendNotificationService
import com.core.domain.model.send_notification.GetFCMResponse
import com.core.domain.repository.send_notification.SendNotificationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SendNotificationRepositoryImpl @Inject constructor(
    private val sendNotificationService: SendNotificationService,
    private val handleRetrofitResponse: HandleRetrofitResponse
) : SendNotificationRepository {
    override suspend fun sendFriendRequestNotification(toToken: String): Flow<Resource<GetFCMResponse>> {
        val title = "Friend Request"
        val body = "You have a new friend request."
        val payload = NotificationPayloadDTO(
            to = toToken,
            notification = NotificationDataDTO(title = title, body = body)
        )

        val authorizationValue = "key=AAAA46AqOVI:APA91bGdRSE96iKm04eryYYsFnnfn4e2HHstp4-_Hjk--QeY4FjnlFdrmifjfRO4LQF7snTbtHYBjpEyTHOx4fJLTq1vFtULnhnL-IAN7MEkA-yuue7aeY8GXYIrmRvwvkIlLH6otxky"

        return handleRetrofitResponse.apiCall {
            sendNotificationService.sendNotification(authorizationValue, payload)
        }.asResource {
            it.toDomain()
        }
    }
}