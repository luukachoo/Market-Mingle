package com.core.domain.model

data class GetSeries(
    val beginAt: String,
    val endAt: String?,
    val fullName: String,
    val id: Int,
    val leagueId: Int,
    val modifiedAt: String,
    val name: String?,
    val season: String?,
    val slug: String,
    val winnerId: Int?,
    val winnerType: String?,
    val year: Int
)
