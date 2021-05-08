package br.curitiba.android.data.repository

import br.curitiba.android.data.datasource.projects.ProjectsCache
import br.curitiba.android.data.datasource.projects.ProjectsRemote
import br.curitiba.android.data.mapper.ProjectMapper
import br.curitiba.android.domain.model.Project
import br.curitiba.android.domain.repository.ProjectsRepository

class ProjectsRepositoryImpl constructor(
    private val projectMapper: ProjectMapper,
    private val projectsRemote: ProjectsRemote,
    private val projectsCache: ProjectsCache,
) : ProjectsRepository {

    override suspend fun getProjects(): List<Project> {
        val isCacheExpired = projectsCache.isCacheExpired()
        val source = if (isCacheExpired) projectsRemote else projectsCache

        return source
            .getProjects()
            .map(projectMapper::mapToDomain)
    }

    override suspend fun bookmarkProject(projectId: String) {
        projectsCache.setProjectAsBookmarked(projectId)
    }

    override suspend fun unbookmarkProject(projectId: String) {
        projectsCache.setProjectAsNotBookmarked(projectId)
    }

    override suspend fun getBookmarkedProjects(): List<Project> {
        return projectsCache
            .getBookmarkedProjects()
            .map(projectMapper::mapToDomain)
    }
}