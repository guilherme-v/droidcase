package br.curitiba.android.domain.model

data class Project(
    val id: String,
    val name: String,
    val fullName: String,
    val starCount: String,
    val dataCreated: String,
    val ownerName: String,
    val ownerAvatar: String,
    val isBookmarked: Boolean
)