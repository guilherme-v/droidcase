package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.usecases.base.UseCase
import br.curitiba.android.domain.repository.ProjectsRepository

class BookmarkProject constructor(
    private val projectsRepository: ProjectsRepository
) : UseCase<Unit, BookmarkProject.Param>() {
    data class Param(val projectId: String)

    override suspend fun execute(params: Param?) {
        if (params == null) throw IllegalArgumentException("Params can't be null")

        return projectsRepository.bookmarkProject(params.projectId);
    }
}