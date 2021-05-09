package br.curitiba.android.remote.repositories

import br.curitiba.android.data.datasource.projects.ProjectsRemote
import br.curitiba.android.data.model.ProjectData
import br.curitiba.android.remote.mapper.ProjectsResponseDtoMapper
import br.curitiba.android.remote.service.GithubService

class ProjectsRemoteImpl(
    private val mapper: ProjectsResponseDtoMapper,
    private val service: GithubService,
) : ProjectsRemote {

    override suspend fun getProjects(): List<ProjectData> {
        return service.searchRepositories(
            query = "language:kotlin",
            order = "stars",
            sortBy = "desc"
        ).items.map(mapper::mapToData)
    }
}