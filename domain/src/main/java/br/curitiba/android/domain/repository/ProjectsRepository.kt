package br.curitiba.android.domain.repository

import br.curitiba.android.domain.model.Project

interface ProjectsRepository {

    suspend fun getProjects(): List<Project>

    suspend fun bookmarkProject(projectId: String)

    suspend fun unbookmarkProject(projectId: String)

    suspend fun getBookmarkedProjects(): List<Project>
}