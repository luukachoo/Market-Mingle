package com.core.data.service.send_notification

import com.core.data.model.send_notification.FCMResponseDTO
import com.core.data.model.send_notification.NotificationPayloadDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface SendNotificationService {
    @POST("v1/projects/market-mingle-ea5c7/messages:send")
    suspend fun sendNotification(
        @Header("Authorization") authorization: String,
        @Body payload: NotificationPayloadDTO
    ): Response<FCMResponseDTO>
}
