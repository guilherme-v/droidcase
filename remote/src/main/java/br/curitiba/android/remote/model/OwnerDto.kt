package br.curitiba.android.remote.model

import com.google.gson.annotations.SerializedName

data class OwnerDto(
    @SerializedName("login") val ownerName: String,
    @SerializedName("avatar_url") val ownerAvatar: String
)