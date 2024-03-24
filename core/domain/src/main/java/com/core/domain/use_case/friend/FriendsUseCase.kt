package com.core.domain.use_case.friend

import javax.inject.Inject

data class FriendsUseCase @Inject constructor(
    val getAddFriendsUseCase: GetAddFriendsUseCase,
    val getFetchFriendsUseCase: GetFetchFriendsUseCase,
    val getFCMTokenUseCase: GetFCMTokenUseCase,
    val getAcceptFriendRequestUseCase: GetAcceptFriendRequestUseCase,
    val getRejectFriendRequestUseCase: GetRejectFriendRequestUseCase,
    val getFetchFriendRequestsUseCase: GetFetchFriendRequestsUseCase,
    val getFetchFriendWithId: GetFetchFriendWithId,
    val getRemoveFriendUseCase: GetRemoveFriendUseCase
)