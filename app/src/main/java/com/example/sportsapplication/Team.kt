package com.example.sportsapplication

data class Team(
    val id: Int,
    val teamName: String,
    val cups: Int,
    val teamYear: Int,
    val country: Country,
    val url: String
)

enum class Country {
    Argentina, Italia, Spain, France, England
}
