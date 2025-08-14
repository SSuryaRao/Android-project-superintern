package com.example.myapplication3

data class LeaderboardEntry(
    val rank: Int,
    val name: String,
    val points: Int,
    // We can add a profile image URL later
    // val profileImageUrl: String
)