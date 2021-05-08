package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.usecases.base.UseCase
import br.curitiba.android.domain.repository.ProjectsRepository

class UnbookmarkProject constructor(
    private val projectsRepository: ProjectsRepository
) : UseCase<Unit, UnbookmarkProject.Param>() {
    data class Param(val projectId: String)

    override suspend fun execute(params: Param?) {
        if (params == null) throw IllegalArgumentException("Params can't be null")

        return projectsRepository.unbookmarkProject(params.projectId);
    }
}