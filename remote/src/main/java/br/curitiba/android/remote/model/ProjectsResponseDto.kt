package br.curitiba.android.remote.model

import com.google.gson.annotations.SerializedName

data class ProjectsResponseDto(
    @SerializedName("items") val items: List<ProjectDto>
)